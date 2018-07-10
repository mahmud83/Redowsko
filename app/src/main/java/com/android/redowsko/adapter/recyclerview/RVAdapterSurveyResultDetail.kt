package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.persistence.model.Answer
import kotlinx.android.synthetic.main.list_question.view.*
import kotlinx.android.synthetic.main.list_survey_result_detail.view.*

class RVAdapterSurveyResultDetail(private val context: Context, private val arrayList: ArrayList<Answer>?) : RecyclerView.Adapter<RVAdapterSurveyResultDetail.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_survey_result_detail,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val surveyResultDetail = arrayList?.get(position)

        holder.v.tvQuestionLSRD.text = (position+1).toString()+". "+surveyResultDetail?.question
        holder.v.tvDescrLSRD.text = "Keterangan : "+surveyResultDetail?.descr
        holder.v.tvOptionsLSRD.text = "Pilihan : "+surveyResultDetail?.options

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)

}