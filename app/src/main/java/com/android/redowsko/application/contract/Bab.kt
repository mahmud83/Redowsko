package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.network.model.Bab

interface Bab {

    interface Presenter{
        fun loadBab()
    }

    interface View:BaseView{
        fun babLoaded(bab:ArrayList<Bab>?)
        fun showProgressBar()
        fun dismissProgressBar()
    }

}