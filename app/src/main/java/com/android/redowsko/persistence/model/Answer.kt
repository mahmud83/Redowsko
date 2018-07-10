package com.android.redowsko.persistence.model

data class Answer (

        var id_answer:Int?,
        var question:String?,
        var descr:String?,
        var options:String?,
        var created_at:String?,
        var updated_at:String?,
        var id_user:Int?,
        var id_surverior_task:String?

)