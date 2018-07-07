package com.android.redowsko.application.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSelectArea
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.SelectArea
import com.android.redowsko.application.presenter.AreaLogic
import kotlinx.android.synthetic.main.activity_select_area.*

class SelectAreaActivity : BaseActivity(),SelectArea.View {

    lateinit var i:Intent
    lateinit var presenter: SelectArea.Presenter
    var bab:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_area)

        setSupportActionBar(tbSArea)
        supportActionBar?.title = "Pilih SelectArea"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = AreaLogic(this,this)
        i = intent
        bab = i.getStringExtra("bab")

        rvSArea.setHasFixedSize(true)
        rvSArea.layoutManager = LinearLayoutManager(this)
        rvSArea.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        tbSArea.setNavigationOnClickListener { this.finish() }

    }

    override fun onResume() {
        super.onResume()
        presenter.loadArea(bab)
    }

    override fun areaLoaded(area: ArrayList<com.android.redowsko.persistence.model.Area>?) {
        val adapter = RVAdapterSelectArea(this,area)
        adapter.notifyDataSetChanged()
        rvSArea.adapter = adapter
    }

}
