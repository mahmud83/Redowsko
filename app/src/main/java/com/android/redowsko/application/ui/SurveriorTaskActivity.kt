package com.android.redowsko.application.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.redowsko.R
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Question
import com.android.redowsko.application.contract.SurveriorTask
import com.android.redowsko.application.presenter.SurveriorTaskLogic
import kotlinx.android.synthetic.main.activity_surverior_task.*

class SurveriorTaskActivity : BaseActivity(), SurveriorTask.View {

    var idSurveriorTask:String? = null
    var idUser:Int? = null
    var idSurverior:Int? = null

    lateinit var presenter: SurveriorTask.Presenter
    lateinit var i:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surverior_task)

        setSupportActionBar(tbST)
        supportActionBar?.title = "Kegiatan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
        tbST.setNavigationOnClickListener {
            this.finish()
            intentTo(HomeActivity::class.java)
        }

        presenter = SurveriorTaskLogic(this,this)
        i = intent

        layoutReST.setOnClickListener { intentTo(SelectBabActivity::class.java) }

    }

    override fun onResume() {
        super.onResume()
        presenter.loadSurveriorTaskById(i.getStringExtra("idSurveriorTask"))
    }

    override fun surveriorTaskLoaded(idSurveriorTask: String?, idUser: Int?, idSurverior: Int?) {
        QuestionActivity.idSurveriorTask = idSurveriorTask
        QuestionActivity.idUser = idUser
        QuestionActivity.idSurverior = idSurverior

        this.idSurveriorTask = idSurveriorTask
        this.idUser = idUser
        this.idSurverior = idSurverior

        Log.d("SURVERIOR_TASK",idSurveriorTask+" "+idUser+" "+idSurverior)

    }

}
