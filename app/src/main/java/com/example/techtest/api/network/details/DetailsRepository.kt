package com.example.techtest.api.network.details

import androidx.lifecycle.MutableLiveData
import com.example.techtest.api.ApiService
import com.example.techtest.models.Fishes
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val apiInstance: ApiService) {
    private var job: CompletableJob? = null

    fun getFishDetails(fishName: String): MutableLiveData<Fishes> {
        job = Job()
        return object : MutableLiveData<Fishes>(){
            override fun onActive() {
                super.onActive()
                job?.let {  detailsDataJob ->

                    CoroutineScope(Dispatchers.IO +detailsDataJob).launch{
                        try{
                            val result = apiInstance.getFishDetails(fishName)

                            withContext(Dispatchers.Main){
                                postValue(result)
                                detailsDataJob.complete()
                            }
                        }catch (e: Exception){
                            println("API call Failed, Reason: ${e.message}")
                        }

                    }

                }
            }
        }
    }

    //for cancel the job
    fun cancelJobs(){
        job?.cancel()
    }
}