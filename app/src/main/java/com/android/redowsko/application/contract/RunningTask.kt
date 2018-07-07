package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.SurveriorTask

interface RunningTask {

    interface Presenter{
        fun loadRunningTask(idUser:String?)
    }

    interface View : BaseView{
        fun runningTaskLoaded(runningTask:ArrayList<SurveriorTask>?)
    }

}