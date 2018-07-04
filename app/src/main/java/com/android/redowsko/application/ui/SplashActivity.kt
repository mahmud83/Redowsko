package com.android.redowsko.application.ui

import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.android.redowsko.R
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.util.sharedpref.UserSession

class SplashActivity : BaseActivity() {

    val DELAY:Long = 1400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed(Runnable {

            if(UserSession(this).hasSession()){
                intentTo(HomeActivity::class.java)
            }else{
                intentTo(LoginActivity::class.java)
            }

        },DELAY)

    }
}
