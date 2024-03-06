package io.github.hiiragi283.material.impl

import com.google.common.collect.ImmutableMap
import com.google.gson.JsonObject
import com.mojang.serialization.Codec
import com.mojang.serialization.JsonOps
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.hiiragi283.api.HTMaterialsAPI
import io.github.hiiragi283.api.extension.*
import io.github.hiiragi283.api.material.HTMaterial
import io.github.hiiragi283.api.material.HTMaterialKey
import io.github.hiiragi283.api.material.HTMaterialRegistry
import io.github.hiiragi283.api.material.composition.HTMaterialComposition
import io.github.hiiragi283.api.material.property.HTPropertyMap
import io.github.hiiragi283.material.HTMaterials
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier

object HTMaterialRegistryImpl : HTMaterialRegistry, SimpleSynchronousResourceReloadListener {
    //    HTMaterialRegistry    //

    override var registry: ImmutableMap<HTMaterialKey, HTMaterial> = ImmutableMap.of()
        private set

    //    SimpleSynchronousResourceReloadListener    //

    private val CODEC: Codec<HTMaterial.Builder> =
        RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.STRING.fieldOf("key").forGetter(HTMaterial.Builder::key),
                HTMaterialComposition.CODEC
                    .orElse(HTMaterialComposition.EMPTY)
                    .fieldOf("composition")
                    .forGetter { it.composition },
                Codec.STRING
                    .listOf()
                    .orElse(listOf())
                    .fieldOf("flags")
                    .forGetter { it.flags.toList() },
                HTPropertyMap.CODEC
                    .orElse(HTPropertyMap())
                    .fieldOf("properties")
                    .forGetter { HTPropertyMap(it.properties) },
            ).apply(instance) { key, composition, flags, properties ->
                HTMaterial.Builder(key).apply {
                    merge(composition, flags, HTPropertyMap.Builder().addAll(properties))
                }
            }
        }

    override fun reload(manager: ResourceManager) {
        HTMaterialRegistry.Builder().run {
            // Reload from Data Pack
            getJsonMultiMap(manager, "material").forEach { (id: Identifier, jsonObjects: Collection<JsonObject>) ->
                jsonObjects.forEach { jsonObject: JsonObject ->
                    runTryAndCatch { decode(CODEC, jsonObject, JsonOps.INSTANCE).let { get(id.path).merge(it) } }
                }
            }
            // Reload from Addons
            HTMaterials.addons.forEach { runTryAndCatch { it.modifyMaterialRegistry(this) } }
            // Initialize
            this@HTMaterialRegistryImpl.registry = this.registry
            onDev {
                registry.values.forEach { material ->
                    encode(material, JsonOps.INSTANCE).let {
                        HTMaterialsAPI.log("Material; $material -> $it")
                    }
                }
            }
            HTMaterialsAPI.log("HTMaterialRegistry initialized!")
        }
    }

    override fun getFabricId(): Identifier = HTMaterialsAPI.id("material")
}
