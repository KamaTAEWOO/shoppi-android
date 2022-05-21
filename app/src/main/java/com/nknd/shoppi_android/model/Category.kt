package com.shoppi.app.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id") val categoryId: String,
    val label: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String,
    val updated: Boolean
)