package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.redowsko.R
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.network.model.Question
import kotlinx.android.synthetic.main.list_question.view.*

class RVAdapterQuestion(private val context: Context, private val arrayList: ArrayList<Question>?) : RecyclerView.Adapter<RVAdapterQuestion.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_question, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val question = arrayList?.get(position)
        holder.view.tvQuestionLQ.text = (position+1).toString()+". "+question?.question

        holder.view.edDescLQ.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isNullOrBlank()){
                    QuestionActivity.answer?.get(position)?.desc = "Belum diisi"
                }else{
                    QuestionActivity.answer?.get(position)?.desc = p0?.toString()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        holder.view.rgLQ.setOnCheckedChangeListener { radioGroup, i ->

            when(i){
                R.id.radio0LQ -> QuestionActivity.answer.get(position)?.option = "0"
                R.id.radio10LQ -> QuestionActivity.answer.get(position)?.option = "10"
                R.id.radio5LQ -> QuestionActivity.answer.get(position)?.option = "5"
                R.id.radioTTDLQ -> QuestionActivity.answer.get(position)?.option = "TTD"
            }

        }

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}