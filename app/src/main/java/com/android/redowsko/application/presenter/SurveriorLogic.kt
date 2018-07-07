package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SelectSurverior
import com.android.redowsko.persistence.DatabaseHelper

class SurveriorLogic(private val view:SelectSurverior.View, private val context: Context) : SelectSurverior.Presenter {

    override fun loadSurverior() {

        val surverior = DatabaseHelper(context).loadSurverior()

        if(surverior.size == 0){
            view.showErrorMessage("Data surverior kosong")
            view.closeActivity()
        }

        view.surveriorLoaded(surverior)

    }
}