package com.android.redowsko.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

        @SerializedName("status") var status:Int?,
        @SerializedName("message") var message:String?,
        @SerializedName("error") var error:Boolean?,
        @SerializedName("id_user") var id_user:Int?

)