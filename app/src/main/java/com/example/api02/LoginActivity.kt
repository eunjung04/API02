package com.example.api02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.api02.datas.User
import com.example.api02.utils.ConnectSever
import com.example.api02.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

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

            ContextUtil.setUserToken(mContext, token)

            val myIntent = Intent(mContext, MyPageActivity::class.java)
            startActivity(myIntent)

            ConnectSever.postRequestLogin(mContext,id,pw, object : ConnectSever)
            override fun onResponse(json:JSONObject) {

                Log.d("로그인응답", json.toString())

                val code=json.getInt("code")

                if (code==200){
                    val data=json.getJSONObject("data")

                    val user

                    val loginUser= User.getUserFromJsonObject(user)

                }
            }


        }

    }


    override fun setValue() {

    }
}
