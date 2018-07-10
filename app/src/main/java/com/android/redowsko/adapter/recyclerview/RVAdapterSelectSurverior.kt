package com.android.redowsko.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.android.redowsko.R
import com.android.redowsko.application.ui.QuestionActivity
import com.android.redowsko.application.ui.SelectHospitalActivity
import com.android.redowsko.application.ui.SurveriorTaskActivity
import com.android.redowsko.persistence.DatabaseHelper
import com.android.redowsko.persistence.model.Surverior
import com.android.redowsko.persistence.model.SurveriorTask
import com.android.redowsko.util.sharedpref.UserSession
import com.valdesekamdem.library.mdtoast.MDToast
import kotlinx.android.synthetic.main.list_select_surverior.view.*

class RVAdapterSelectSurverior(private val context: Context, private val surverior:ArrayList<Surverior>?) : RecyclerView.Adapter<RVAdapterSelectSurverior.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_select_surverior,parent,false))
    }

    override fun getItemCount(): Int = surverior?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val surverior = surverior?.get(position)

        holder.v.tvSurveriorLSS.text = (position+1).toString()+". "+surverior?.name

        holder.v.setOnClickListener {

            MaterialDialog.Builder(context)
                    .title("Kegiatan")
                    .input("Input kegiatan survey",null,false,MaterialDialog.InputCallback { dialog, input ->

                        if(DatabaseHelper(context).isSurveriorTaskExist(input.toString().toLowerCase())){
                            MDToast.makeText(context,"Nama kegiatan sudah ada",MDToast.LENGTH_SHORT,MDToast.TYPE_ERROR).show()
                        }else{
                            DatabaseHelper(context).insertSurveriorTask(input.toString().toLowerCase(),surverior?.id_surverior!!,UserSession(context).getIdUser().toInt())
                            val i = Intent(context,SurveriorTaskActivity::class.java)
                            i.putExtra("idSurveriorTask",input.toString().toLowerCase())
                            context.startActivity(i)
                        }

                    })
                    .negativeText("BATAL")
                    .inputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
                    .show()

        }


    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)
}