package com.example.domain.model

import com.example.common.model.DomainModel

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
): DomainModel