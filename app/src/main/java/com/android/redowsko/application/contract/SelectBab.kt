package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Bab

interface SelectBab {

    interface Presenter{
        fun loadBab()
    }

    interface View:BaseView{
        fun babLoaded(bab:ArrayList<Bab>?)
    }

}