package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.AreaActivity
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.network.model.Area
import com.android.redowsko.network.model.Bab
import com.android.redowsko.network.model.Question
import kotlinx.android.synthetic.main.list_area.view.*

class RVAdapterArea(private val context: AreaActivity, private val arrayList: ArrayList<Area>?) : RecyclerView.Adapter<RVAdapterArea.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_area, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val area = arrayList?.get(position)
        holder.view.tvAreaBL.text = (position+1).toString()+". "+area?.area
        holder.view.setOnClickListener {
            val i = Intent(context,QuestionActivity::class.java)
            i.putExtra("bab",context.bab)
            i.putExtra("area",area?.area)
            context.startActivity(i)
        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}