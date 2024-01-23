package com.example.techtest.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.data.usecase.GetProductsUseCaseImpl
import com.example.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getProductsUseCaseImpl: GetProductsUseCaseImpl): ViewModel(){

    private  val _products = MutableLiveData(HomeState())
    val products : LiveData<HomeState> get() = _products

    init {
        viewModelScope.launch {
            getProducts()
        }
    }


    private suspend fun getProducts(){
        getProductsUseCaseImpl().onEach {
            when(it){
                is Resource.Loading->{
                    _products.value = HomeState(isLoading = true)
                }
                is Resource.Success->{
                    _products.value = HomeState(data =  it.data)
                }
                is Resource.Error->{
                    _products.value = HomeState(error =  it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}