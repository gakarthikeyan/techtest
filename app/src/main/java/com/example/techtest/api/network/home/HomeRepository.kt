package com.example.techtest.api.network.home

import androidx.lifecycle.LiveData
import com.example.techtest.api.ApiService
import com.example.techtest.models.Fishes
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiInstance: ApiService) {
    private var job: CompletableJob? = null

    fun getMasterData(): LiveData<Fishes> {
        job = Job()
        return object : LiveData<Fishes>(){
            override fun onActive() {
                super.onActive()
                job?.let {  masterDataJob ->

                    CoroutineScope(IO+masterDataJob).launch{
                        try{
                            val result = apiInstance.getFishes()

                            withContext(Main){
                                value = result
                                masterDataJob.complete()
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