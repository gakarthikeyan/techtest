package com.example.data.network.model.products

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)