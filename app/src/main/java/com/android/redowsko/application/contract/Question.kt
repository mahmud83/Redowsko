package com.android.redowsko.application.contract

import android.content.Context
import com.android.redowsko.adapter.recyclerview.RVAdapterQuestion
import com.android.redowsko.application.base.BaseView
import com.android.redowsko.util.dummymodel.Answer
import com.android.redowsko.network.model.Question

interface Question {

    interface Presenter{
        fun loadQuestion(bab:String?,area:String?,idSurverior:String?)
        fun saveAnswer(context: Context,question:ArrayList<Question>?)
    }

    interface View : BaseView{
        fun questionLoaded(question:ArrayList<Question>?)
        fun showProgressBar()
        fun dismissProgressBar()
    }

}