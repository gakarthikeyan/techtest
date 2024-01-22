package com.example.data.mappers

import com.example.data.network.model.products.Product
import com.example.data.network.model.products.ProductDTO
import com.example.data.network.model.products.Products
import com.example.data.network.model.products.ProductsDTO

fun List<ProductDTO>.toProductDomain(): List<Product> {
    return map {
        Product(
            brand = it.brand,
            category = it.category,
            description = it.description,
            discountPercentage = it.discountPercentage,
            id = it.id,
            images = it.images,
            price = it.price,
            rating = it.rating,
            stock = it.stock,
            thumbnail = it.thumbnail,
            title = it.title,
        )
    }
}

fun ProductDTO.toProductDomain(): Product {
    return Product(
        brand = brand,
        category = category,
        description = description,
        discountPercentage = discountPercentage,
        id = id,
        images = images,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail,
        title = title,
    )
}

fun ProductsDTO.toAllProductsDomain(): Products {
    return Products(
        limit = limit,
        products = products.toProductDomain(),
        skip = skip,
        total = total
    )
}
