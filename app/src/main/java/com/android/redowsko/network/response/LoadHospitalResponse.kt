package com.android.redowsko.network.response

import com.android.redowsko.network.model.Hospital
import com.android.redowsko.network.model.Question
import com.android.redowsko.network.model.Surverior
import com.google.gson.annotations.SerializedName

data class LoadHospitalResponse (

        @SerializedName("status") var status:Int?,
        @SerializedName("message") var message:String?,
        @SerializedName("error") var error:Boolean?,
        @SerializedName("hospital") var hospital:ArrayList<Hospital>?

)