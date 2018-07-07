package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.SelectAreaActivity
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.application.ui.SurveriorTaskActivity
import com.android.redowsko.persistence.model.Area
import com.android.redowsko.persistence.model.SurveriorTask
import kotlinx.android.synthetic.main.list_running_task.view.*
import kotlinx.android.synthetic.main.list_select_area.view.*

class RVAdapterRunningTask(private val context: Context, private val arrayList: ArrayList<SurveriorTask>?) : RecyclerView.Adapter<RVAdapterRunningTask.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_running_task, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val task = arrayList?.get(position)
        holder.view.tvTaskNameLRT.text = (position+1).toString()+". "+task?.id_surverior_task
        holder.view.setOnClickListener {
            val i = Intent(context,SurveriorTaskActivity::class.java)
            i.putExtra("idSurveriorTask",task?.id_surverior_task)
            context.startActivity(i)
        }

        holder.view.imgDeleteLRT.setOnClickListener {

        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}