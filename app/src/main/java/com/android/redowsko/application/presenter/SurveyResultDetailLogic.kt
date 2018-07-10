package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SurveyResultDetail
import com.android.redowsko.persistence.DatabaseHelper

class SurveyResultDetailLogic(private val view:SurveyResultDetail.View, private val context: Context) : SurveyResultDetail.Presenter {

    override fun loadSurveyDetail(idSurveriorTask: String?) {
        val data = DatabaseHelper(context).loadAnswerDetailByTask(idSurveriorTask)
        view.surveyDetailLoaded(data)
    }
}