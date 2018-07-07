package com.android.redowsko.network

import com.android.redowsko.network.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("redowsko/load_question")
    fun loadQuestion() : Call<LoadQuestionResponse>

    @GET("redowsko/login")
    fun login(
            @Query("email")email:String?,
            @Query("password")password:String?
    ) : Call<LoginResponse>

    @GET("redowsko/user_detail")
    fun userDetail(
            @Query("id_user")idUser:String?
    ) : Call<UserDetailResponse>

    @GET("redowsko/load_surverior")
    fun loadSurverior() : Call<LoadSurveriorResponse>

    @GET("redowsko/load_hospital")
    fun loadHospital() : Call<LoadHospitalResponse>

}