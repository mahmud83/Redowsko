package com.android.redowsko.application.ui


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.redowsko.R
import com.android.redowsko.application.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : BaseFragment() {

    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Beranda"

        v.btnStartSurveyHome.setOnClickListener { intentTo(SelectSurveriorActivity::class.java) }

        return v
    }


}
