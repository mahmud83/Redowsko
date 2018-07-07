package com.android.redowsko.application.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSelectHospital
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.SelectHospital
import com.android.redowsko.application.presenter.SelectHospitalLogic
import com.android.redowsko.persistence.model.Hospital
import kotlinx.android.synthetic.main.activity_select_hospital.*

class SelectHospitalActivity : BaseActivity(), SelectHospital.View {

    lateinit var presenter: SelectHospital.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_hospital)

        setSupportActionBar(tbSHospital)
        supportActionBar?.title = "Pilih Rumah Sakit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tbSHospital.setNavigationOnClickListener { this.finish() }

        presenter = SelectHospitalLogic(this,this)

        rvSHospital.setHasFixedSize(true)
        rvSHospital.layoutManager = LinearLayoutManager(this)
        rvSHospital.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadHospital()
    }

    override fun hospitalLoaded(hospital: ArrayList<Hospital>?) {
        val adapter = RVAdapterSelectHospital(this,hospital)
        adapter.notifyDataSetChanged()
        rvSHospital.adapter = adapter
    }

}
