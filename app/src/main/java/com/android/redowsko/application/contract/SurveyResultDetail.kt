package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Answer

interface SurveyResultDetail {

    interface Presenter{
        fun loadSurveyDetail(idSurveriorTask:String?)
    }

    interface View : BaseView{
        fun surveyDetailLoaded(data:ArrayList<Answer>?)
    }

}