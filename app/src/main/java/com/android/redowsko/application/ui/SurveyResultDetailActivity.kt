package com.android.redowsko.application.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSurveyResultDetail
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.SurveyResultDetail
import com.android.redowsko.application.presenter.SurveyResultDetailLogic
import com.android.redowsko.persistence.model.Answer
import kotlinx.android.synthetic.main.activity_survey_result_detail.*

class SurveyResultDetailActivity : BaseActivity(),SurveyResultDetail.View {

    lateinit var presenter: SurveyResultDetail.Presenter
    lateinit var i:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result_detail)

        setSupportActionBar(tbSRD)
        supportActionBar?.title = "Data Survei Hasil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tbSRD.setNavigationOnClickListener { this.finish() }

        presenter = SurveyResultDetailLogic(this,this)
        i = intent

        rvSRD.setHasFixedSize(true)
        rvSRD.layoutManager = LinearLayoutManager(this)
        rvSRD.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        presenter.loadSurveyDetail(i.getStringExtra("idSurveriorTask"))
    }

    override fun surveyDetailLoaded(data: ArrayList<Answer>?) {
        val adapter = RVAdapterSurveyResultDetail(this,data)
        adapter.notifyDataSetChanged()
        rvSRD.adapter = adapter
        Log.d("SAVED ANSWER",data?.toString())
    }

}
