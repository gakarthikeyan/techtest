package com.example.domain.repository

import com.example.data.mappers.toAllProductsDomain
import com.example.data.mappers.toProductDomain
import com.example.data.network.ApiDataService
import com.example.data.network.model.products.Product
import com.example.data.network.model.products.Products
import com.example.data.network.utils.SafeApiRequest
import javax.inject.Inject

class GetProductsRepositoryImpl @Inject constructor(private val apiService: ApiDataService): GetProductsRepository, SafeApiRequest(){

    override suspend fun getProduct(): Product {
        val response = safeApiRequest { apiService.getProduct() }
        return response.toProductDomain()
    }

    override suspend fun getAllProducts(): Products {
        val response =  safeApiRequest { apiService.getAllProducts() }
        return response.toAllProductsDomain()
    }

}