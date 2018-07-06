package com.android.redowsko.application.presenter

import android.text.TextUtils
import android.util.Log
import com.android.redowsko.application.contract.Login
import com.android.redowsko.network.ApiConfig
import com.android.redowsko.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Response

class LoginLogic(private val view:Login.View) : Login.Presenter{

    override fun performLogin(email: String?, password: String?) {

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            view.showErrorMessage("Info login tidak boleh kosong")
        }else{

            view.showProgressBar()
            ApiConfig().instance().login(email,password)
                    .enqueue(object : retrofit2.Callback<LoginResponse>{

                        override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                            Log.d("ONFAILURE",t.toString())
                            view.showErrorMessage("Koneksi internet gagal. Coba Lagi.")
                            view.dismissProgressBar()
                        }

                        override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {

                            if(response?.body()?.error == false && response?.body()?.message?.equals("Login berhasil",true)!!){
                                view.dismissProgressBar()
                                view.onLoginSuccess(response?.body()?.id_user?.toString())
                            }else{
                                view.dismissProgressBar()
                                view.showErrorMessage(response?.body()?.message)
                            }

                        }

                    })

        }

    }

}