package com.example.techtest.viewmodel.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.techtest.api.network.details.DetailsRepository
import com.example.techtest.models.Fishes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: DetailsRepository): ViewModel() {

//    fetch sing fish details through the repository
    fun getFishDetails(fishName: String): MutableLiveData<Fishes>{
        return repository.getFishDetails(fishName)
    }

//    cancel coroutine job
    fun cancelJob(){
        repository.cancelJobs()
    }
}