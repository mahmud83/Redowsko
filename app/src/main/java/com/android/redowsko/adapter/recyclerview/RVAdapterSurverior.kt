package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.persistence.model.Surverior
import kotlinx.android.synthetic.main.list_surverior.view.*

class RVAdapterSurverior(private val context: Context, private val surverior:ArrayList<Surverior>?) : RecyclerView.Adapter<RVAdapterSurverior.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_surverior,parent,false))
    }

    override fun getItemCount(): Int = surverior?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val surverior = surverior?.get(position)

        holder.v.tvSurveriorLS.text = surverior?.name

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)
}