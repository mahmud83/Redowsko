package com.android.redowsko.adapter.recyclerview

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.SelectAreaActivity
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.persistence.model.Area
import kotlinx.android.synthetic.main.list_select_area.view.*

class RVAdapterSelectArea(private val context: SelectAreaActivity, private val arrayList: ArrayList<Area>?) : RecyclerView.Adapter<RVAdapterSelectArea.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_select_area, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val area = arrayList?.get(position)
        holder.view.tvAreaLSA.text = (position+1).toString()+". "+area?.area
        holder.view.setOnClickListener {
            QuestionActivity.area = area?.area
            val i = Intent(context,QuestionActivity::class.java)
            context.startActivity(i)
        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}