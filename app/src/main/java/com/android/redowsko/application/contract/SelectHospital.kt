package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Hospital

interface SelectHospital {

    interface Presenter{
        fun loadHospital()
    }

    interface View : BaseView{
        fun hospitalLoaded(hospital:ArrayList<Hospital>?)
    }

}