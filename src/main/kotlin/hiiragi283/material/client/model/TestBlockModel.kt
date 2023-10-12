package hiiragi283.material.client.model

import com.mojang.datafixers.util.Pair
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.renderer.v1.Renderer
import net.fabricmc.fabric.api.renderer.v1.RendererAccess
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext
import net.minecraft.block.BlockState
import net.minecraft.client.render.model.*
import net.minecraft.client.render.model.json.ModelOverrideList
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.texture.Sprite
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.item.ItemStack
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockRenderView
import java.util.*
import java.util.function.Function
import java.util.function.Supplier

@Environment(EnvType.CLIENT)
object TestBlockModel : UnbakedModel, BakedModel, FabricBakedModel {

    private val spriteIds: MutableList<SpriteIdentifier> = mutableListOf(
        SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, Identifier("block/furnace_front_on")),
        SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, Identifier("block/furnace_top"))
    )

    private lateinit var sprites: List<Sprite>
    private lateinit var mesh: Mesh

    //    UnbakedModel    //

    override fun getModelDependencies(): MutableCollection<Identifier> = mutableListOf()

    override fun getTextureDependencies(
        unbakedModelGetter: Function<Identifier, UnbakedModel>,
        unresolvedTextureReferences: MutableSet<Pair<String, String>>
    ): MutableCollection<SpriteIdentifier> = spriteIds

    override fun bake(
        loader: ModelLoader,
        textureGetter: Function<SpriteIdentifier, Sprite>,
        rotationContainer: ModelBakeSettings,
        modelId: Identifier
    ): BakedModel {
        //Set sprites
        sprites = spriteIds.map(textureGetter::apply)
        //Get Renderer. Mesh Builder, and Quad Emitter
        val renderer: Renderer = RendererAccess.INSTANCE.renderer ?: return this
        val meshBuilder: MeshBuilder = renderer.meshBuilder()
        val quadEmitter: QuadEmitter = meshBuilder.emitter
        //Emit squares
        Direction.entries.forEach { direction: Direction ->
            val spriteIndex: Int = if (direction.axis == Direction.Axis.Y) 1 else 0
            quadEmitter.square(direction, 0f, 0f, 1f, 1f, 0f)
            quadEmitter.spriteBake(0, sprites[spriteIndex], MutableQuadView.BAKE_LOCK_UV)
            quadEmitter.spriteColor(0, -1, -1, -1, -1)
            quadEmitter.emit()
        }
        //Save Built Mesh
        mesh = meshBuilder.build()
        return this
    }

    //    BakedModel    //

    override fun getQuads(state: BlockState?, face: Direction?, random: Random): MutableList<BakedQuad> =
        mutableListOf()

    override fun useAmbientOcclusion(): Boolean = true

    override fun isBuiltin(): Boolean = false

    override fun hasDepth(): Boolean = false

    override fun isSideLit(): Boolean = true

    override fun getParticleSprite(): Sprite = sprites[0]

    override fun getTransformation(): ModelTransformation = ModelHelper.MODEL_TRANSFORM_BLOCK

    override fun getOverrides(): ModelOverrideList = ModelOverrideList.EMPTY

    //    FabricBakedModel    //

    override fun isVanillaAdapter(): Boolean = false

    override fun emitBlockQuads(
        blockView: BlockRenderView,
        state: BlockState,
        pos: BlockPos,
        randomSupplier: Supplier<Random>,
        context: RenderContext
    ) = context.meshConsumer().accept(mesh)

    override fun emitItemQuads(stack: ItemStack, randomSupplier: Supplier<Random>, context: RenderContext) {
        context.meshConsumer().accept(mesh)
    }

}