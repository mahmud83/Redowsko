package com.android.redowsko.application.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSurverior
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Surverior
import com.android.redowsko.application.presenter.SurveriorLogic
import kotlinx.android.synthetic.main.activity_surverior.*

class SurveriorActivity : BaseActivity(),Surverior.View {

    lateinit var presenter:Surverior.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surverior)

        setSupportActionBar(tbSurverior)
        supportActionBar?.title = "Pilih bidang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tbSurverior.setNavigationOnClickListener { this.finish() }

        presenter = SurveriorLogic(this,this)

        rvSurverior.setHasFixedSize(true)
        rvSurverior.layoutManager = LinearLayoutManager(this)
        rvSurverior.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadSurverior()
    }

    override fun surveriorLoaded(surverior: ArrayList<com.android.redowsko.persistence.model.Surverior>?) {
        val adapter = RVAdapterSurverior(this,surverior)
        adapter.notifyDataSetChanged()
        rvSurverior.adapter = adapter
    }
}
