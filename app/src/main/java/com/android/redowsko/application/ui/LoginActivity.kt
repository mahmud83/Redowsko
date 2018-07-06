package com.android.redowsko.application.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.redowsko.R
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Login
import com.android.redowsko.application.presenter.LoginLogic
import com.android.redowsko.util.sharedpref.UserSession
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), Login.View {

    lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(tbLogin)
        supportActionBar?.title = "Login"

        presenter = LoginLogic(this)

        btnLogin.setOnClickListener { presenter.performLogin(edEmailLogin.text.toString(),edPasswordLogin.text.toString()) }

    }

    override fun onLoginSuccess(userId: String?) {
        UserSession(this).makeSession(userId)
        intentTo(HomeActivity::class.java)
    }

    override fun showProgressBar() {
        flLoadingLogin.visibility = View.VISIBLE
        btnLogin.visibility = View.GONE
    }

    override fun dismissProgressBar() {
        flLoadingLogin.visibility = View.GONE
        btnLogin.visibility = View.VISIBLE
    }

}
