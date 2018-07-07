package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.application.ui.SelectAreaActivity
import com.android.redowsko.persistence.model.Bab
import kotlinx.android.synthetic.main.list_select_bab.view.*

class RVAdapterSelectBab(private val context: Context, private val arrayList: ArrayList<Bab>?) : RecyclerView.Adapter<RVAdapterSelectBab.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_select_bab, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val bab = arrayList?.get(position)
        holder.view.tvBabLSB.text = (position+1).toString()+". "+bab?.bab?.toUpperCase()
        holder.view.setOnClickListener {
            QuestionActivity.bab = bab?.bab
            val i = Intent(context,SelectAreaActivity::class.java)
            i.putExtra("bab",bab?.bab)
            context.startActivity(i)
        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}