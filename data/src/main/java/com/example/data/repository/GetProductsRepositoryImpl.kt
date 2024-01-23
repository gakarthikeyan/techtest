package com.example.data.repository

import com.example.data.mappers.ProductDomainModelMapper
import com.example.data.mappers.ProductsDomainModelMapper
import com.example.data.network.ApiDataService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.Product
import com.example.domain.model.Products
import com.example.domain.repository.GetProductsRepository
import javax.inject.Inject

class GetProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiDataService,
    private val productsDomainModelMapper: ProductsDomainModelMapper,
    private val productDomainModelMapper: ProductDomainModelMapper
): GetProductsRepository, SafeApiRequest(){

    override suspend fun getProduct(): Product {
        val response = safeApiRequest { apiService.getProduct() }
        return productDomainModelMapper.mapDataModelToDomainModel(response)
    }

    override suspend fun getAllProducts(): Products {
        val response =  safeApiRequest { apiService.getAllProducts() }
        return productsDomainModelMapper.mapDataModelToDomainModel(response)
    }

}