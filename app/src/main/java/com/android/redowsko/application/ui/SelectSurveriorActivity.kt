package com.android.redowsko.application.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSelectSurverior
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.SelectSurverior
import com.android.redowsko.application.presenter.SurveriorLogic
import kotlinx.android.synthetic.main.activity_select_surverior.*

class SelectSurveriorActivity : BaseActivity(),SelectSurverior.View {

    lateinit var presenter:SelectSurverior.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_surverior)

        setSupportActionBar(tbSSurverior)
        supportActionBar?.title = "Pilih bidang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tbSSurverior.setNavigationOnClickListener { this.finish() }

        presenter = SurveriorLogic(this,this)

        rvSSurverior.setHasFixedSize(true)
        rvSSurverior.layoutManager = LinearLayoutManager(this)
        rvSSurverior.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadSurverior()
    }

    override fun surveriorLoaded(surverior: ArrayList<com.android.redowsko.persistence.model.Surverior>?) {
        val adapter = RVAdapterSelectSurverior(this,surverior)
        adapter.notifyDataSetChanged()
        rvSSurverior.adapter = adapter
    }
}
