package com.android.redowsko.application.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.afollestad.materialdialogs.DialogAction
import com.afollestad.materialdialogs.MaterialDialog
import com.android.redowsko.R
import com.android.redowsko.application.base.BaseActivity
import com.android.redowsko.application.contract.Home
import com.android.redowsko.application.presenter.HomeLogic
import com.android.redowsko.persistence.DatabaseHelper
import com.android.redowsko.util.sharedpref.SyncUserLogin
import com.android.redowsko.util.sharedpref.UserDetail
import com.android.redowsko.util.sharedpref.UserSession
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener,Home.View {

    lateinit var presenter: Home.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        presenter = HomeLogic(this,this)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.flHome,HomeFragment()).commit()

    }

    override fun onResume() {
        super.onResume()

        if(UserDetail(this).getName().isNullOrBlank()){
            presenter.loadUserDetail(UserSession(this).getIdUser())
            Log.d("USERDETAIL","DATA IS NULL")
        }

        if(!SyncUserLogin(this).hasSync()){
            presenter.syncAfterLogin()
            Log.d("SYNC","DATA SYNC")
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fm = supportFragmentManager
        when (item.itemId) {
            R.id.nav_home -> {
                fm.beginTransaction().replace(R.id.flHome,HomeFragment()).commit()
            }
            R.id.nav_surverior_task -> {
                fm.beginTransaction().replace(R.id.flHome,RunningTaskFragment()).commit()
            }
            R.id.nav_surverior_done ->{
                fm.beginTransaction().replace(R.id.flHome,SurveyResultFragment()).commit()
            }
            R.id.nav_logout -> {

                MaterialDialog.Builder(this)
                        .title("Konfirmasi")
                        .content("Logout dari akun ?")
                        .positiveText("LOGOUT")
                        .negativeText("BATAL")
                        .onPositive(object : MaterialDialog.SingleButtonCallback{
                            override fun onClick(dialog: MaterialDialog, which: DialogAction) {
                                UserSession(this@HomeActivity).destroySession()
                                SyncUserLogin(this@HomeActivity).removeSync()
                                UserDetail(this@HomeActivity).clearData()
                                finish()
                                intentTo(LoginActivity::class.java)
                            }
                        })
                        .show()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun loadUserDetailFailed() {
        MaterialDialog.Builder(this)
                .title("Gagal")
                .content("Gagal memuat data dari user, Koneksi internet mungkin bermasalah")
                .positiveText("COBA LAGI")
                .negativeText("TUTUP")
                .onPositive(object : MaterialDialog.SingleButtonCallback{
                    override fun onClick(dialog: MaterialDialog, which: DialogAction) {
                        onRestart()
                    }
                })
                .onNegative(object : MaterialDialog.SingleButtonCallback{
                    override fun onClick(dialog: MaterialDialog, which: DialogAction) {
                        finishAffinity()
                    }
                })
    }

    override fun loadUserDetailSuccess(name: String, position: String, email: String, phone: String, city: String, address: String?, gender: String) {
        val detail = UserDetail(this)
        detail.fillAllData(name,position,email,phone,city,address,gender)
    }

    override fun syncSuccess() {
        SyncUserLogin(this).setSync()
    }

}
