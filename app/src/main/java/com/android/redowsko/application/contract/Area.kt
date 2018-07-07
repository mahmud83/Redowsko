package com.android.redowsko.application.contract

import com.android.redowsko.application.base.BaseView
import com.android.redowsko.persistence.model.Area

interface Area {

    interface Presenter{
        fun loadArea(bab:String?)
    }

    interface View:BaseView{
        fun areaLoaded(area:ArrayList<Area>?)
    }

}