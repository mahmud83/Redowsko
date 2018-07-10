package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Answer

interface SurveyResult {

    interface Presenter{
        fun loadAnswerByTask()
    }

    interface View : BaseView{
        fun answerByTaskLoaded(data:ArrayList<Answer>?)
    }

}