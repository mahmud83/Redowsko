package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SurveriorTask
import com.android.redowsko.persistence.DatabaseHelper

class SurveriorTaskLogic(private val view:SurveriorTask.View, private val context: Context) : SurveriorTask.Presenter {

    override fun loadSurveriorTaskById(idSurveriorTask: String?) {

        val getIdSurveriorTask = DatabaseHelper(context).loadSurveriorTaskById(idSurveriorTask!!)?.get(0)?.id_surverior_task
        val getIdUser = DatabaseHelper(context).loadSurveriorTaskById(idSurveriorTask!!)?.get(0)?.id_user
        val getIdSurverior = DatabaseHelper(context).loadSurveriorTaskById(idSurveriorTask!!)?.get(0)?.id_surverior

        view.surveriorTaskLoaded(getIdSurveriorTask,getIdUser,getIdSurverior)

    }

}