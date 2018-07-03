package com.android.redowsko.application.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.android.redowsko.R
import com.valdesekamdem.library.mdtoast.MDToast

open class BaseActivity : AppCompatActivity(), BaseView{

    lateinit var loading:MaterialDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val materialDialog = MaterialDialog.Builder(this)
        materialDialog.progress(true,0)
        materialDialog.content(R.string.progress_dialog)
        materialDialog.cancelable(false)
        loading = materialDialog.build()

    }

    fun intentTo(target:Class<*>){
        startActivity(Intent(this,target))
    }

    override fun showErrorMessage(message: String?) {
        MDToast.makeText(this,message,MDToast.LENGTH_SHORT,MDToast.TYPE_ERROR).show()
    }

    override fun showSuccessMessage(message: String?) {
        MDToast.makeText(this,message,MDToast.LENGTH_SHORT,MDToast.TYPE_SUCCESS).show()
    }

    override fun showInfoMessage(message: String?) {
        MDToast.makeText(this,message,MDToast.LENGTH_SHORT,MDToast.TYPE_INFO).show()
    }

    override fun showProgressDialog() {
        loading.show()
    }

    override fun dismissProgressDialog() {
        if(loading.isShowing)
            loading.dismiss()
    }

    override fun closeActivity() {
        this.finish()
    }

}