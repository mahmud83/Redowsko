package com.android.redowsko.application.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterBab
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Bab
import com.android.redowsko.application.presenter.BabLogic
import kotlinx.android.synthetic.main.activity_bab.*
import android.support.v7.widget.DividerItemDecoration



class BabActivity : BaseActivity(),Bab.View {

    lateinit var presenter: Bab.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bab)

        setSupportActionBar(tbBab)
        supportActionBar?.title = "Pilih BAB"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = BabLogic(this)

        tbBab.setNavigationOnClickListener { this.finish() }

        rvBab.setHasFixedSize(true)
        rvBab.layoutManager = LinearLayoutManager(this)
        rvBab.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadBab()
    }

    override fun babLoaded(bab: ArrayList<com.android.redowsko.network.model.Bab>?) {
        val adapter = RVAdapterBab(this,bab)
        adapter.notifyDataSetChanged()
        rvBab.adapter = adapter
    }

    override fun showProgressBar() {
        pbBab.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        pbBab.visibility = View.GONE
    }

}
