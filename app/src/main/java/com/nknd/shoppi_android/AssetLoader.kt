package com.nknd.shoppi_android

import android.content.Context
import android.util.Log

class AssetLoader {

    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String {
        // assets json file call
        // it -> inputStream
        return context.assets.open("home.json").use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}