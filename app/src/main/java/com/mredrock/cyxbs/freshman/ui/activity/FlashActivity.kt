package com.mredrock.cyxbs.freshman.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.leancloud.AVUser
import com.mredrock.cyxbs.freshman.R

class FlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_flash)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = getWindow().getDecorView()
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;  View.SYSTEM_UI_FLAG_LAYOUT_STABLE

            decorView.setSystemUiVisibility(option)
            getWindow().setStatusBarColor(Color.TRANSPARENT)
        }
        val actionBar = getSupportActionBar()
        actionBar?.hide()

        val splashThread = object : Thread() {
            override fun run() {
                try {
                    sleep(2700)
                    val currentUser =AVUser.getCurrentUser()
                    if (currentUser!=null){
                        val intent=Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        splashThread.start()
    }
}
