package com.android.redowsko.application.presenter

import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.application.contract.Area
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoadAreaResponse
import com.android.redowsko.network.response.LoadBabResponse
import retrofit2.Call
import retrofit2.Response

class AreaLogic(private val view: Area.View) : Area.Presenter{

    override fun loadArea(bab: String?) {
        view.showProgressBar()

        ApiConfig().instance().loadArea(bab)
                .enqueue(object : retrofit2.Callback<LoadAreaResponse>{

                    override fun onFailure(call: Call<LoadAreaResponse>?, t: Throwable?) {
                        view.dismissProgressBar()
                        view.showErrorMessage("Koneksi gagal, coba lagi.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<LoadAreaResponse>?, response: Response<LoadAreaResponse>?) {

                        if(response?.body()?.area?.size == 0){
                            view.closeActivity()
                            view.showInfoMessage("Data area kosong")
                        }

                        view.dismissProgressBar()
                        view.areaLoaded(response?.body()?.area)

                    }

                })
    }

}