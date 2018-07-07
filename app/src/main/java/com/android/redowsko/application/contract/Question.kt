package com.android.redowsko.application.contract

import android.content.Context
import com.android.redowsko.adapter.recyclerview.RVAdapterQuestion
import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Question
import com.android.redowsko.util.dummymodel.Answer

interface Question {

    interface Presenter{
        fun loadQuestion(bab:String?,area:String?,idSurverior:Int?)
        fun saveAnswer(context: Context,question:ArrayList<Question>?)
    }

    interface View : BaseView{
        fun questionLoaded(question:ArrayList<com.android.redowsko.persistence.model.Question>?)
    }

}