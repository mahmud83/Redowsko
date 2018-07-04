package com.android.redowsko.network.response

import com.android.redowsko.network.model.User
import com.google.gson.annotations.SerializedName

data class UserDetailResponse(

        @SerializedName("status") var status:Int?,
        @SerializedName("message") var message:String?,
        @SerializedName("error") var error:Boolean?,
        @SerializedName("user") var user:User?

)