package com.example.data.network.model.products


import com.google.gson.annotations.SerializedName

data class ProductsDTO(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("products")
    val products: List<ProductDTO>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
)