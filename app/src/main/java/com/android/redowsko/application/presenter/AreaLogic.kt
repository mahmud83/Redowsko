package com.android.redowsko.application.presenter

import android.content.Context
import com.android.redowsko.application.contract.SelectArea
import com.android.redowsko.persistence.DatabaseHelper

class AreaLogic(private val view: SelectArea.View, private val context: Context) : SelectArea.Presenter{

    override fun loadArea(bab: String?) {

        val area = DatabaseHelper(context).loadArea(bab)
        if(area.size == 0){
            view.showErrorMessage("Data area kosong")
            view.closeActivity()
        }

        view.areaLoaded(area)

    }

}