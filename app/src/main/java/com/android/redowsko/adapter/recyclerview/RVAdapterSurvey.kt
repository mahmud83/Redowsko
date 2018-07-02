package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R

class RVAdapterSurvey(private val context: Context, private val arrayList: ArrayList<*>?) : RecyclerView.Adapter<RVAdapterSurvey.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_survey, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val postion = arrayList?.get(position)

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}