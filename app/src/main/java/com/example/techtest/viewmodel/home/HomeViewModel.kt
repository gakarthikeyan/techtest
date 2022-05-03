package com.example.techtest.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.techtest.api.network.home.HomeRepository
import com.example.techtest.models.Fishes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository): ViewModel() {

    fun getAllFishes(): LiveData<Fishes>{
        return repository.getMasterData()
    }

    fun cancelJob(){
        repository.cancelJobs()
    }
}