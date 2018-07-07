package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SelectHospital
import com.android.redowsko.persistence.DatabaseHelper

class SelectHospitalLogic(private val view:SelectHospital.View, private val context: Context) : SelectHospital.Presenter{

    override fun loadHospital() {

        val hospital = DatabaseHelper(context).loadHospital()

        if(hospital.size == 0){
            view.closeActivity()
            view.showErrorMessage("Data rumah sakit kosong")
        }

        view.hospitalLoaded(hospital)

    }

}