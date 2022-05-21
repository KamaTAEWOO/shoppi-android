//package com.shoppi.app.model
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//sealed class CartProduct
//data class CartHeader(
//    val brandName: String
//): CartProduct()
//
//@Entity(
//    tableName = "cart_item"
//)
//data class CartItem(
//    @PrimaryKey @ColumnInfo(name = "product_id") val productId: String,
//    val label: String,
//    val price: Int,
//    @ColumnInfo(name = "brand_name") val brandName: String,
//    @ColumnInfo(name = "thumbnail_image_url") val thumbnailImageUrl: String,
//    val type: String,
//    val amount: Int
//): CartProduct()