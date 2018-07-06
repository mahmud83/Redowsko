package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView

interface Login {

    interface Presenter{
        fun performLogin(email:String?,password:String?)
    }

    interface View : BaseView{
        fun onLoginSuccess(userId:String?)
        fun showProgressBar()
        fun dismissProgressBar()
    }

}