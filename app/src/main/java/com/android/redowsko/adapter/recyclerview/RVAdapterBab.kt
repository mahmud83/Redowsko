package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.AreaActivity
import com.android.redowsko.network.model.Bab
import com.android.redowsko.network.model.Question
import kotlinx.android.synthetic.main.list_bab.view.*

class RVAdapterBab(private val context: Context, private val arrayList: ArrayList<Bab>?) : RecyclerView.Adapter<RVAdapterBab.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_bab, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val bab = arrayList?.get(position)
        holder.view.tvBabBL.text = (position+1).toString()+". "+bab?.bab?.toUpperCase()
        holder.view.setOnClickListener {
            val i = Intent(context,AreaActivity::class.java)
            i.putExtra("bab",bab?.bab)
            context.startActivity(i)
        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}