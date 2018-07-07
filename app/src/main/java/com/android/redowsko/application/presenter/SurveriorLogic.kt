package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.Surverior
import com.android.redowsko.persistence.DatabaseHelper

class SurveriorLogic(private val view:Surverior.View, private val context: Context) : Surverior.Presenter {

    override fun loadSurverior() {

        val surverior = DatabaseHelper(context).loadSurverior()

        if(surverior.size == 0){
            view.showErrorMessage("Data surverior kosong")
            view.closeActivity()
        }

        view.surveriorLoaded(surverior)

    }
}