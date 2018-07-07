package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SelectBab
import com.android.redowsko.persistence.DatabaseHelper

class BabLogic(private val view:SelectBab.View, private val context: Context) : SelectBab.Presenter {

    override fun loadBab() {

        val bab = DatabaseHelper(context).loadBab()

        if(bab.size == 0){
            view.showErrorMessage("Data bab kosong")
            view.closeActivity()
        }

        view.babLoaded(bab)

    }

}