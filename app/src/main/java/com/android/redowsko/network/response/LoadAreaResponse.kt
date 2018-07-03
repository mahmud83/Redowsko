package com.android.redowsko.network.response

import com.android.redowsko.network.model.Area
import com.android.redowsko.network.model.Bab
import com.android.redowsko.network.model.Question
import com.google.gson.annotations.SerializedName

data class LoadAreaResponse (

        @SerializedName("status") var status:Int?,
        @SerializedName("message") var message:String?,
        @SerializedName("error") var error:Boolean?,
        @SerializedName("area") var area:ArrayList<Area>?

)