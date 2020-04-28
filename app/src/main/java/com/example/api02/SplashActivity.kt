package com.example.api02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : BaseActivity() {
    override fun setupEvents() {

    }

    override fun setValue() {

        //2.5초동안 보여준 뒤=>로그인 액티비티로 전환
        Handler().postDelayed({

            val myIntent=Intent(mContext, LoginActivity::class.java)
            startActivity(myIntent)
            finish()

        }, 2500)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
