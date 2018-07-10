package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SurveyResult
import com.android.redowsko.persistence.DatabaseHelper

class SurveyResultLogic(private val view:SurveyResult.View, private val context: Context) : SurveyResult.Presenter {

    override fun loadAnswerByTask() {

        val data = DatabaseHelper(context).loadAnswer()

        if(data.size == 0){
            view.showErrorMessage("Data survey hasil masih kosong")
        }

        view.answerByTaskLoaded(data)

    }

}