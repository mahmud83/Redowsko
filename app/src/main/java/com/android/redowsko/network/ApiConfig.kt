package com.android.redowsko.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    companion object {
        const val BASE_URL = ""
    }

    private fun retrofit() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun instance() : ApiInterface{
        return retrofit().create(ApiInterface::class.java)
    }

}