package com.android.redowsko.application.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSelectBab
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.SelectBab
import com.android.redowsko.application.presenter.BabLogic
import kotlinx.android.synthetic.main.activity_select_bab.*
import android.support.v7.widget.DividerItemDecoration



class SelectBabActivity : BaseActivity(),SelectBab.View {

    lateinit var presenter: SelectBab.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_bab)

        setSupportActionBar(tbSBab)
        supportActionBar?.title = "Pilih BAB"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = BabLogic(this,this)

        tbSBab.setNavigationOnClickListener { this.finish() }

        rvSBab.setHasFixedSize(true)
        rvSBab.layoutManager = LinearLayoutManager(this)
        rvSBab.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadBab()
    }

    override fun babLoaded(bab: ArrayList<com.android.redowsko.persistence.model.Bab>?) {
        val adapter = RVAdapterSelectBab(this,bab)
        adapter.notifyDataSetChanged()
        rvSBab.adapter = adapter
    }

}
