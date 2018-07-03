package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.util.dummymodel.Answer
import com.android.redowsko.network.model.Question

interface Question {

    interface Presenter{
        fun loadQuestion(bab:String?,area:String?,idSurverior:String?)
        fun saveAnswer(size:Int)
    }

    interface View : BaseView{
        fun questionLoaded(question:ArrayList<Question>?)
        fun showProgressBar()
        fun dismissProgressBar()
    }

}