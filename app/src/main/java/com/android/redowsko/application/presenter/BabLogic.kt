package com.android.redowsko.application.presenter

import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.application.contract.Bab
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoadBabResponse
import retrofit2.Call
import retrofit2.Response

class BabLogic(private val view:Bab.View) : Bab.Presenter {

    override fun loadBab() {

        view.showProgressBar()

        ApiConfig().instance().loadBab()
                .enqueue(object : retrofit2.Callback<LoadBabResponse>{

                    override fun onFailure(call: Call<LoadBabResponse>?, t: Throwable?) {
                        view.dismissProgressBar()
                        view.showErrorMessage("Koneksi gagal, coba lagi.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<LoadBabResponse>?, response: Response<LoadBabResponse>?) {

                        if(response?.body()?.bab?.size == 0){
                            view.closeActivity()
                            view.showInfoMessage("Data BAB kosong")
                        }

                        view.dismissProgressBar()
                        view.babLoaded(response?.body()?.bab)

                    }

                })

    }

}