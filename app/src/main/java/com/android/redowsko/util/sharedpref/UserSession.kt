package com.android.redowsko.util.sharedpref

import android.content.Context
import android.content.SharedPreferences

class UserSession(private val context: Context) {

    val sp:SharedPreferences = context.getSharedPreferences("user",0)
    val edit:SharedPreferences.Editor = sp.edit()

    fun makeSession(idUser:String){
        edit.putString("idUser",idUser)
        edit.commit()
    }

    fun hasSession() : Boolean{
        return if(sp.getString("idUser",null).isNullOrBlank()){
            false
        }else{
            true
        }
    }

    fun getIdUser() : String{
        return sp.getString("idUser",null)
    }

}