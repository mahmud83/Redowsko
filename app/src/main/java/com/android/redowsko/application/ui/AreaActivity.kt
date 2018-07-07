package com.android.redowsko.application.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterArea
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Area
import com.android.redowsko.application.presenter.AreaLogic
import kotlinx.android.synthetic.main.activity_area.*

class AreaActivity : BaseActivity(),Area.View {

    lateinit var i:Intent
    lateinit var presenter: Area.Presenter
    var bab:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        setSupportActionBar(tbArea)
        supportActionBar?.title = "Pilih Area"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = AreaLogic(this)
        i = intent
        bab = i.getStringExtra("bab")

        rvArea.setHasFixedSize(true)
        rvArea.layoutManager = LinearLayoutManager(this)
        rvArea.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        tbArea.setNavigationOnClickListener { this.finish() }

    }

    override fun onResume() {
        super.onResume()
        presenter.loadArea(bab)
    }

    override fun areaLoaded(area: ArrayList<com.android.redowsko.persistence.model.Area>?) {
        val adapter = RVAdapterArea(this,area)
        adapter.notifyDataSetChanged()
        rvArea.adapter = adapter
    }

}
