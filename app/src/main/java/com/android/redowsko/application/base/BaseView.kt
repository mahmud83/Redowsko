package com.android.redowsko.application.base

interface BaseView {
    fun showErrorMessage(message:String?)
    fun showSuccessMessage(message:String?)
    fun showInfoMessage(message:String?)
    fun showProgressDialog()
    fun dismissProgressDialog()
    fun closeActivity()
    fun intentTo(target:Class<*>)
}