package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView

interface SurveriorTask {

    interface Presenter{
        fun loadSurveriorTaskById(idSurveriorTask:String?)
    }

    interface View:BaseView{
        fun surveriorTaskLoaded(idSurveriorTask:String?, idUser:Int?, idSurverior:Int?)
    }

}