package com.example.data.network.model.products


import com.example.common.model.DataModel
import com.google.gson.annotations.SerializedName

data class ProductsEntity(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("products")
    val products: List<ProductEntity>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
): DataModel