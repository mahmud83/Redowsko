package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Surverior

interface SelectSurverior {

    interface Presenter{
        fun loadSurverior()
    }

    interface View : BaseView {
        fun surveriorLoaded(surverior:ArrayList<Surverior>?)
    }

}