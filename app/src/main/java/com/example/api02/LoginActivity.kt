package com.example.api02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api02.utils.ConnectSever
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValue()
    }

    override fun setupEvents() {

        loginIdEdt.setOnClickListener {
            //아이디/비번 받아서=>서버에 로그인 요청

            val id=loginIdEdt.text.toString()
            val pw=pwEdt.text.toString()

            ConnectSever.postRequestLogin(mContext,id,pw, object : ConnectSever)
            override fun onResponse


        }

    }


    override fun setValue() {

    }
}
