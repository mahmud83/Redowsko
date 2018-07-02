package com.android.redowsko.application.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.redowsko.R
import com.android.redowsko.application.base.BaseFragment


class HomeFragment : BaseFragment() {

    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)



        return v
    }


}
