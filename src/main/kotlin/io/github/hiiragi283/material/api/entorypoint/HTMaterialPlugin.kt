package io.github.hiiragi283.material.api.entorypoint

import io.github.hiiragi283.material.common.HTMaterialsCommon
import net.fabricmc.loader.api.FabricLoader

@Suppress("unused")
object HTMaterialPlugin {

    fun interface Pre {

        companion object {

            private const val KEY: String = "${HTMaterialsCommon.MOD_ID}.pre"

            internal fun preInitializes() {
                FabricLoader.getInstance().getEntrypoints(KEY, Pre::class.java).forEach(Pre::preInitialize)
            }

        }

        fun preInitialize()

    }

    fun interface Post {

        companion object {

            private const val KEY: String = "${HTMaterialsCommon.MOD_ID}.post"

            internal fun postInitializes() {
                FabricLoader.getInstance().getEntrypoints(KEY, Post::class.java).forEach(Post::postInitialize)
            }

        }

        fun postInitialize()

    }

}