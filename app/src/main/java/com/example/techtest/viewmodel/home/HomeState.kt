package com.example.techtest.viewmodel.home

import com.example.domain.model.FishesItem

data class HomeState(
    var isLoading: Boolean = false,
    var data: List<FishesItem>? = null,
    var error: String = ""
)