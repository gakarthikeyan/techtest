package com.tek.contentrights.di


import com.example.techtest.BuildConfig
import com.example.techtest.api.ApiService
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

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getApiServiceInstance(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    private fun loggingInterceptor(): Interceptor{
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY // debug build logging
        } else {
            interceptor.level =
                HttpLoggingInterceptor.Level.NONE // changed BODY to NONE to avoid OOM(Out of Memory) issue
        }
        return  interceptor
    }

    private val client = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder().method(original.method, original.body)
            .build()
        return@Interceptor chain.proceed(request)
    })
        .addInterceptor(loggingInterceptor())
        .build()
}