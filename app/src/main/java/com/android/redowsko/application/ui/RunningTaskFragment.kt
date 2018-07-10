package com.android.redowsko.application.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterRunningTask
import com.android.redowsko.application.base.BaseFragment
import com.android.redowsko.application.contract.RunningTask
import com.android.redowsko.application.presenter.RunningTaskLogic
import com.android.redowsko.persistence.model.SurveriorTask
import com.android.redowsko.util.sharedpref.UserSession
import kotlinx.android.synthetic.main.fragment_running_task.view.*


class RunningTaskFragment : BaseFragment(), RunningTask.View{

    lateinit var v:View
    lateinit var presenter: RunningTask.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_running_task, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Survey berjalan"

        presenter = RunningTaskLogic(this,context!!)
        v.rvRTask.setHasFixedSize(true)
        v.rvRTask.layoutManager = LinearLayoutManager(activity)
        v.rvRTask.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))

        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadRunningTask(UserSession(context!!).getIdUser())
    }

    override fun runningTaskLoaded(runningTask: ArrayList<SurveriorTask>?) {
        val adapter = RVAdapterRunningTask(context!!,runningTask)
        adapter.notifyDataSetChanged()
        v.rvRTask.adapter = adapter
    }


}
