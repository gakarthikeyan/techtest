package com.example.data.network.utils

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T: Any> safeApiRequest(call: suspend ()-> Response<T>): T {
        val response = call.invoke()
        if(response.isSuccessful) {
            return response.body() ?: throw NullPointerException("Expression 'response.body()' must not be null")
        }else{
            val responseErr = response.errorBody()?.toString()
            val message = StringBuilder()
            responseErr?.let {
                try {
                    message.append(JSONObject(it).getString("error"))

                }catch (e: JSONException){
                    e.printStackTrace()
                }

            }
            Log.d("API Request", "Response -> ${message}")

            throw ApiException(message.toString())

        }
    }
}