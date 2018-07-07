package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.persistence.model.Hospital
import com.android.redowsko.persistence.model.Surverior
import kotlinx.android.synthetic.main.list_select_hospital.view.*
import kotlinx.android.synthetic.main.list_select_surverior.view.*

class RVAdapterSelectHospital(private val context: Context, private val hospital:ArrayList<Hospital>?) : RecyclerView.Adapter<RVAdapterSelectHospital.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_select_hospital,parent,false))
    }

    override fun getItemCount(): Int = hospital?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val hospital = hospital?.get(position)

        holder.v.tvHospitalLSH.text = hospital?.name

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)
}