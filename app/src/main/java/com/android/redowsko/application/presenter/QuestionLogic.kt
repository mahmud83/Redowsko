package com.android.redowsko.application.presenter

import android.content.Context
import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterQuestion
import com.android.redowsko.application.contract.Question
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.util.dummymodel.Answer
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoadQuestionResponse
import com.android.redowsko.util.sharedpref.UserSession
import retrofit2.Call
import retrofit2.Response

class QuestionLogic(private val view:Question.View) : Question.Presenter{

    override fun loadQuestion(bab: String?, area: String?, idSurverior: String?) {

        view.showProgressBar()


    }

    override fun saveAnswer(context: Context, question: ArrayList<com.android.redowsko.network.model.Question>?) {

        QuestionActivity.answer.clear()

        for(i in 0 until question!!.size){
            QuestionActivity.answer.add(Answer(
                    i,
                    "Belum diisi",
                    "Belum dipilih",
                    null,
                    null,
                    0,
                    0,
                    UserSession(context).getIdUser().toInt()
            ))
        }

    }

}