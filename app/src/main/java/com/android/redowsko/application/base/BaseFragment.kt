package com.android.redowsko.application.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.android.redowsko.R
import com.valdesekamdem.library.mdtoast.MDToast

open class BaseFragment : Fragment(),BaseView{

    lateinit var loading: MaterialDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val materialDialog = MaterialDialog.Builder(activity!!)
        materialDialog.progress(true,0)
        materialDialog.content(R.string.progress_dialog)
        materialDialog.cancelable(false)
        loading = materialDialog.build()
    }

    fun intentTo(target:Class<*>){
        startActivity(Intent(activity,target))
    }

    override fun showErrorMessage(message: String?) {
        MDToast.makeText(activity,message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
    }

    override fun showSuccessMessage(message: String?) {
        MDToast.makeText(activity,message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
    }

    override fun showInfoMessage(message: String?) {
        MDToast.makeText(activity,message, MDToast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
    }

    override fun showProgressDialog() {
        loading.show()
    }

    override fun dismissProgressDialog() {
        if(loading.isShowing)
            loading.dismiss()
    }

    override fun closeActivity() {
        activity?.finish()
    }

}