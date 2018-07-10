package com.android.redowsko.application.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterSurveyResult
import com.android.redowsko.application.base.BaseFragment
import com.android.redowsko.application.contract.SurveyResult
import com.android.redowsko.application.presenter.SurveyResultLogic
import com.android.redowsko.persistence.model.Answer
import kotlinx.android.synthetic.main.fragment_survey_result.view.*

class SurveyResultFragment : BaseFragment(), SurveyResult.View {

    lateinit var v: View
    lateinit var presenter: SurveyResult.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v =inflater.inflate(R.layout.fragment_survey_result, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Survey Hasil"

        presenter = SurveyResultLogic(this,context!!)

        v.rvSR.setHasFixedSize(true)
        v.rvSR.layoutManager = LinearLayoutManager(activity)
        v.rvSR.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadAnswerByTask()
    }

    override fun answerByTaskLoaded(data: ArrayList<Answer>?) {

        val adapter = RVAdapterSurveyResult(context!!,data)
        adapter.notifyDataSetChanged()
        v.rvSR.adapter = adapter
    }


}
