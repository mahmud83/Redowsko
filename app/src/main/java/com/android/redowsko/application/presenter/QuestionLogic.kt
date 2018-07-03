package com.android.redowsko.application.presenter

import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterQuestion
import com.android.redowsko.application.contract.Question
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.util.dummymodel.Answer
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoadQuestionResponse
import retrofit2.Call
import retrofit2.Response

class QuestionLogic(private val view:Question.View) : Question.Presenter{

    override fun loadQuestion(bab: String?, area: String?, idSurverior: String?) {

        view.showProgressBar()

        ApiConfig().instance().loadQuestion(bab,area,idSurverior)
                .enqueue(object : retrofit2.Callback<LoadQuestionResponse>{

                    override fun onFailure(call: Call<LoadQuestionResponse>?, t: Throwable?) {
                        view.dismissProgressBar()
                        view.showErrorMessage("Koneksi gagal, coba lagi.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<LoadQuestionResponse>?, response: Response<LoadQuestionResponse>?) {

                        if(response?.body()?.question?.size == 0){
                            view.closeActivity()
                            view.showInfoMessage("Data pertanyaan kosong")
                        }

                        view.dismissProgressBar()
                        view.questionLoaded(response?.body()?.question)

                    }

                })

    }

    override fun saveAnswer(size: Int) {

        for(i in 0 until size){
            QuestionActivity.answer.add(Answer("Belum diisi","Belum dipilih"))
        }

    }

}