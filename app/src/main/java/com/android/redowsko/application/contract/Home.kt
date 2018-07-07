package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView

interface Home {

    interface Presenter{
        fun loadUserDetail(idUser:String?)
        fun syncAfterLogin()
    }

    interface View : BaseView{
        fun loadUserDetailFailed()
        fun loadUserDetailSuccess(name:String,position:String,email:String,phone:String,city:String,address:String?,gender:String)
        fun syncSuccess()
    }

}