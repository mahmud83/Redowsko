package com.android.redowsko.application.ui

import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.android.redowsko.R
import com.android.redowsko.adapter.recyclerview.RVAdapterQuestion
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Question
import com.android.redowsko.application.presenter.QuestionLogic
import com.android.redowsko.util.dummymodel.Answer
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : BaseActivity(), Question.View {

    lateinit var presenter: Question.Presenter
    lateinit var i:Intent

    companion object {
        var answer = ArrayList<Answer>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        setSupportActionBar(tbQuestion)
        supportActionBar?.title = "Data pertanyaan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tbQuestion.setNavigationOnClickListener { this.finish() }

        presenter = QuestionLogic(this)
        i = intent

        rvQuestion.setHasFixedSize(true)
        rvQuestion.layoutManager = LinearLayoutManager(this)
        rvQuestion.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        btnSaveQuestion.setOnClickListener {

            var hasil:String? = ""

            for(i in 0 until answer.size){
                hasil += (i+1).toString()+". "+answer?.get(i)?.desc+"\nPilihan : "+answer?.get(i)?.option+"\n\n"
            }

            MaterialDialog.Builder(this)
                    .title("Hasil")
                    .content(""+hasil)
                    .positiveText("OK")
                    .show()

        }

    }

    override fun onResume() {
        super.onResume()
        presenter.loadQuestion(i.getStringExtra("bab"),i.getStringExtra("area"),"1")
    }

    override fun questionLoaded(question: ArrayList<com.android.redowsko.network.model.Question>?) {
        val adapter = RVAdapterQuestion(this,question)
        adapter.notifyDataSetChanged()
        rvQuestion.adapter = adapter
        presenter.saveAnswer(this,question)
    }

    override fun showProgressBar() {
        pbQuestion.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        pbQuestion.visibility = View.GONE
    }

}
