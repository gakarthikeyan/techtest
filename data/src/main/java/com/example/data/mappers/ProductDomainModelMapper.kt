package com.example.data.mappers

import com.example.common.extension.DataToDomainMapper
import com.example.data.network.model.products.ProductEntity
import com.example.domain.model.Product
import javax.inject.Inject

class ProductDomainModelMapper @Inject constructor(): DataToDomainMapper<ProductEntity, Product> {
    override fun mapDataModelToDomainModel(dataModel: ProductEntity): Product {
        return dataModel.let {
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
}