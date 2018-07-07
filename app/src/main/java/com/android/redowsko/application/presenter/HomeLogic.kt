package com.android.redowsko.application.presenter

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.redowsko.application.contract.Home
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoadHospitalResponse
import com.android.redowsko.network.response.LoadQuestionResponse
import com.android.redowsko.network.response.LoadSurveriorResponse
import com.android.redowsko.network.response.UserDetailResponse
import com.android.redowsko.persistence.DatabaseHelper
import retrofit2.Call
import retrofit2.Response

class HomeLogic(private val view:Home.View, private val context: Context) : Home.Presenter{

    override fun loadUserDetail(idUser: String?) {

        view.showProgressDialog()
        ApiConfig().instance().userDetail(idUser)
                .enqueue(object : retrofit2.Callback<UserDetailResponse>{

                    override fun onFailure(call: Call<UserDetailResponse>?, t: Throwable?) {
                        Log.d("ONFAILURE",t.toString())
                        view.dismissProgressDialog()
                        view.loadUserDetailFailed()
                    }

                    override fun onResponse(call: Call<UserDetailResponse>?, response: Response<UserDetailResponse>?) {

                        if(response?.body()?.error == false && response?.body()?.message?.equals("data user ditemukan",true)!!){

                            view.dismissProgressDialog()
                            view.loadUserDetailSuccess(
                                    response?.body()?.user?.name!!,
                                    response?.body()?.user?.position!!,
                                    response?.body()?.user?.email!!,
                                    response?.body()?.user?.phone!!,
                                    response?.body()?.user?.city!!,
                                    response?.body()?.user?.address!!,
                                    response?.body()?.user?.gender!!
                            )

                        }else{
                            view.dismissProgressDialog()
                            view.loadUserDetailFailed()
                        }

                    }

                })

    }

    override fun syncAfterLogin() {

        class task : AsyncTask<Void, Void, Void>(){

            override fun doInBackground(vararg p0: Void?): Void? {
                syncSurverior()
                syncHospital()
                syncQuestion()
                return null
            }

            override fun onPostExecute(result: Void?) {
                view.dismissProgressDialog()
                view.syncSuccess()
            }

            override fun onPreExecute() {
                view.showProgressDialog()
            }
        }

        task().execute()

    }

    private fun syncSurverior(){

        ApiConfig().instance().loadSurverior()
                .enqueue(object : retrofit2.Callback<LoadSurveriorResponse>{

                    override fun onFailure(call: Call<LoadSurveriorResponse>?, t: Throwable?) {
                        Log.d("ONFAILURE",t.toString())
                        view.dismissProgressDialog()
                        view.loadUserDetailFailed()
                    }

                    override fun onResponse(call: Call<LoadSurveriorResponse>?, response: Response<LoadSurveriorResponse>?) {

                        for(i in 0 until response?.body()?.surverior?.size!!){

                            DatabaseHelper(context).insertSurverior(response?.body()?.surverior?.get(i)?.id_surverior,
                                    response?.body()?.surverior?.get(i)?.name)

                        }
                        Log.d("SYNC_SURVERIOR","SUCCESS")
                        Log.d("TOTAL_SURVERIOR_RECORD",DatabaseHelper(context).loadSurverior().size.toString())

                    }

                })

    }

    private fun syncQuestion(){

        ApiConfig().instance().loadQuestion()
                .enqueue(object : retrofit2.Callback<LoadQuestionResponse>{

                    override fun onFailure(call: Call<LoadQuestionResponse>?, t: Throwable?) {
                        view.dismissProgressDialog()
                        Log.d("ONFAILURE",t.toString())
                        view.loadUserDetailFailed()
                    }

                    override fun onResponse(call: Call<LoadQuestionResponse>?, response: Response<LoadQuestionResponse>?) {

                        for(i in 0 until response?.body()?.question?.size!!){

                            DatabaseHelper(context).insertQuestion(response?.body()?.question?.get(i)?.id_question,
                                    response?.body()?.question?.get(i)?.question,
                                    response?.body()?.question?.get(i)?.bab,
                                    response?.body()?.question?.get(i)?.area,
                                    response?.body()?.question?.get(i)?.standar,
                                    response?.body()?.question?.get(i)?.ep,
                                    response?.body()?.question?.get(i)?.id_surverior)

                        }
                        Log.d("SYNC_QUESTION","SUCCESS")
                        Log.d("TOTAL_QUESTION_RECORD",DatabaseHelper(context).loadQuestion().size.toString())

                    }

                })

    }

    private fun syncHospital(){

        ApiConfig().instance().loadHospital()
                .enqueue(object : retrofit2.Callback<LoadHospitalResponse>{
                    override fun onFailure(call: Call<LoadHospitalResponse>?, t: Throwable?) {
                        Log.d("ONFAILURE",t.toString())
                        view.dismissProgressDialog()
                        view.loadUserDetailFailed()

                    }

                    override fun onResponse(call: Call<LoadHospitalResponse>?, response: Response<LoadHospitalResponse>?) {

                        for(i in 0 until response?.body()?.hospital?.size!!){

                            DatabaseHelper(context).insertHospital(response?.body()?.hospital?.get(i)?.id_hospital,
                                    response?.body()?.hospital?.get(i)?.name,
                                    response?.body()?.hospital?.get(i)?.address,
                                    response?.body()?.hospital?.get(i)?.lat,
                                    response?.body()?.hospital?.get(i)?.lng,
                                    response?.body()?.hospital?.get(i)?.email,
                                    response?.body()?.hospital?.get(i)?.phone)

                        }
                        Log.d("SYNC_HOSPITAL","SUCCESS")
                        Log.d("TOTAL_HOSPITAL_RECORD",DatabaseHelper(context).loadHospital().size.toString())

                    }
                })

    }

}