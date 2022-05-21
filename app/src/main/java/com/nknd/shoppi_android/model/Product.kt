package com.shoppi.app.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("brand_name") val brandName: String?,
    val label: String,
    @SerializedName("discount_rate") val discountRate: Int,
    val price: Int,
    val type: String?,
    @SerializedName("thumbnail_image_url")
    val thumbnailImageUrl: String,
    @SerializedName("representative_image_url")
    val representativeImageUrl: String?,
    val descriptions: List<Description>?,
    @SerializedName("product_id") val productId: String
)

data class Description(
    val id: String,
    @SerializedName("image_url") val imageUrl: String
)