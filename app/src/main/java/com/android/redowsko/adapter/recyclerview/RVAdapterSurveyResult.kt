package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.SurveyResultDetailActivity
import com.android.redowsko.persistence.model.Answer
import kotlinx.android.synthetic.main.list_survey_result.view.*

class RVAdapterSurveyResult(private val context: Context, private val arrayList:ArrayList<Answer>?) : RecyclerView.Adapter<RVAdapterSurveyResult.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_survey_result,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val surveyResult = arrayList?.get(position)

        holder.v.tvSurveyLSR.text = (position+1).toString()+". "+surveyResult?.id_surverior_task
        holder.v.setOnClickListener {
            val i = Intent(context,SurveyResultDetailActivity::class.java)
            i.putExtra("idSurveriorTask",surveyResult?.id_surverior_task)
            context.startActivity(i)
        }

    }

    class Holder(val v:View) : RecyclerView.ViewHolder(v)

}