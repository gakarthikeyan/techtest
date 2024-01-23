package com.example.data.mappers

import com.example.common.extension.DataToDomainMapper
import com.example.data.network.model.products.ProductEntity
import com.example.data.network.model.products.ProductsEntity
import com.example.domain.model.Product
import com.example.domain.model.Products
import javax.inject.Inject

class ProductsDomainModelMapper @Inject constructor(): DataToDomainMapper<ProductsEntity, Products> {
    override fun mapDataModelToDomainModel(dataModel: ProductsEntity): Products {
        return dataModel.let {
            Products(
                limit = it.limit,
                products = toProductDomain(it.products),
                skip = it.skip,
                total = it.total
            )
        }
    }

    private fun toProductDomain(products: List<ProductEntity>): List<Product>{
        return products.map {
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