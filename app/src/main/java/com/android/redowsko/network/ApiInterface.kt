package com.android.redowsko.network

import com.android.redowsko.network.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("redowsko/load_question")
    fun loadQuestion() : Call<LoadQuestionResponse>

    @FormUrlEncoded
    @POST("redowsko/login")
    fun login(
            @Field("email")email:String?,
            @Field("password")password:String?
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