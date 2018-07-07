package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.RunningTask
import com.android.redowsko.persistence.DatabaseHelper

class RunningTaskLogic(private val view:RunningTask.View, private val context: Context) : RunningTask.Presenter {

    override fun loadRunningTask(idUser: String?) {

        val runningTask = DatabaseHelper(context).loadSurveriorTask(idUser?.toInt()!!)

        if(runningTask.size == 0){
            view.showErrorMessage("Kegiataan belum ada")
        }

        view.runningTaskLoaded(runningTask)

    }

}