package com.android.redowsko.util.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SyncUserLogin(private val context: Context) {

    val sp:SharedPreferences = context.getSharedPreferences("SYNC_USER_LOGIN",0)
    val edit:SharedPreferences.Editor = sp.edit()

    fun setSync(){

        edit.putBoolean("sync",true)
        edit.commit()

    }

    fun hasSync() : Boolean{

        return sp.getBoolean("sync",false)

    }

    fun removeSync(){

        edit.clear()
        edit.commit()

    }

}