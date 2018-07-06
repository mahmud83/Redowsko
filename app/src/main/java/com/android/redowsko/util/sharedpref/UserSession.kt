package com.android.redowsko.util.sharedpref

import android.content.Context
import android.content.SharedPreferences

class UserSession(private val context: Context) {

    val sp:SharedPreferences = context.getSharedPreferences("USER_SESSION",0)
    val edit:SharedPreferences.Editor = sp.edit()

    fun makeSession(idUser:String?){
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

    fun destroySession(){
        edit.clear()
        edit.commit()
    }

    fun getIdUser() : String{
        return sp.getString("idUser",null)
    }

}