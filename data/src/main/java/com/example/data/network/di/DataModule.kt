package com.example.data.network.di

import com.example.data.network.ApiDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    //    config di for Retrofit instance
    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // config di for API Service instance
    @Singleton
    @Provides
    fun getApiServiceInstance(retrofit: Retrofit): ApiDataService {
        return retrofit.create(ApiDataService::class.java)
    }
    //    config interceptor for logging purpose (only applicable in debug mode)
    private fun loggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY // debug build logging
       /* } else {
            interceptor.level =
                HttpLoggingInterceptor.Level.NONE // changed BODY to NONE to avoid OOM(Out of Memory) issue
        }*/
        return  interceptor
    }

    //    config HTTP Clint to add various interceptor ( as per our need, here I am using only for logging)
    private val client = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder().method(original.method, original.body)
            .build()
        return@Interceptor chain.proceed(request)
    }).addInterceptor(loggingInterceptor()).build()

}