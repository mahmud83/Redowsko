package com.android.redowsko.network.response

import com.android.redowsko.network.model.Question
import com.google.gson.annotations.SerializedName

data class LoadQuestionResponse (

        @SerializedName("status") var status:Int?,
        @SerializedName("message") var message:String?,
        @SerializedName("error") var error:Boolean?,
        @SerializedName("question") var question:ArrayList<Question>?

)