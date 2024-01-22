package com.example.techtest.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.data.usecases.GetFishItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getFishItemUseCase: GetFishItemUseCase): ViewModel(){

    private  val _fishItem = MutableLiveData(HomeState())
    val fishItem : LiveData<HomeState> get() = _fishItem

    init {
        getFishItems()
    }


    private fun getFishItems(){
        getFishItemUseCase().onEach {
            when(it){
                is Resource.Loading->{
                    _fishItem.value = HomeState(isLoading = true)
                }
                is Resource.Success->{
                    _fishItem.value = HomeState(data =  it.data)
                }
                is Resource.Error->{
                    _fishItem.value = HomeState(error =  it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}