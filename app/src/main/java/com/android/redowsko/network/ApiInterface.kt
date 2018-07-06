package com.android.redowsko.network

import com.android.redowsko.network.response.LoadAreaResponse
import com.android.redowsko.network.response.LoadBabResponse
import com.android.redowsko.network.response.LoadQuestionResponse
import com.android.redowsko.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("redowsko/load_bab")
    fun loadBab() : Call<LoadBabResponse>

    @GET("redowsko/load_area")
    fun loadArea(
            @Query("bab")bab:String?
    ) : Call<LoadAreaResponse>

    @GET("redowsko/load_question")
    fun loadQuestion(
            @Query("bab")bab:String?,
            @Query("area")area:String?,
            @Query("id_surverior")idSurverior:String?
    ) : Call<LoadQuestionResponse>

    @GET("redowsko/login")
    fun login(
            @Query("email")email:String?,
            @Query("password")password:String?
    ) : Call<LoginResponse>

}