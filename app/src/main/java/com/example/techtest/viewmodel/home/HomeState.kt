package com.example.techtest.viewmodel.home

import com.example.domain.model.products.Products

data class HomeState(
    var isLoading: Boolean = false,
//    var data: List<FishesItem>? = null,
//    var data: List<Product>? = null,
    var data: Products? = null,
    var error: String = ""
)