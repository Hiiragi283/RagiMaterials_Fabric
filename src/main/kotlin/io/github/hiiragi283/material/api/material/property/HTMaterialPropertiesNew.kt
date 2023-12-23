package io.github.hiiragi283.material.api.material.property

import io.github.hiiragi283.material.api.material.HTMaterialNew

class HTMaterialPropertiesNew private constructor(
    val map: Map<HTPropertyKey<*>, HTMaterialProperty<*>>
) : Map<HTPropertyKey<*>, HTMaterialProperty<*>> by map {

    fun <T : HTMaterialProperty<T>> getAs(key: HTPropertyKey<T>): T? = key.clazz.cast(this[key])

    fun verify(material: HTMaterialNew) {
        this.values.forEach { it.verify(material) }
    }

    //    Any    //

    override fun toString(): String = this.keys.joinToString(separator = ", ")

    //    Builder    //

    class Builder : MutableMap<HTPropertyKey<*>, HTMaterialProperty<*>> by hashMapOf() {

        inline fun <T : HTMaterialProperty<T>> add(
            property: T,
            action: T.() -> Unit = {}
        ) {
            this[property.key] = property.apply(action)
        }

        internal fun build(): HTMaterialPropertiesNew = HTMaterialPropertiesNew(this)

    }

}