package com.example.api02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.api02.datas.GlobalData
import com.example.api02.datas.User
import com.example.api02.utils.ConnectSever
import com.example.api02.utils.ContextUtil
import org.json.JSONObject

class SplashActivity : BaseActivity() {
    override fun setupEvents() {

    }

    override fun setValue() {

        //2.5초동안 보여준 뒤=>로그인 액티비티로 전환
        Handler().postDelayed({

            if(ContextUtil.getUserToken(mContext)==""){
                val myIntent=Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()


            }

            else{

                //토큰이 저장되어있다면=>이 토큰으로 사용자 정보를 받아서
                //글로벌데이터에 저장 하고=>액티비티 전환

                val myIntent=Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()

                ConnectSever.getRequestMyInfo(mContext, object :ConnectSever.JsonResponseHandler{
                    override fun onResponse(json: JSONObject) {

                        Log.d("내응답정보", json.toString())

                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")
                        val nowUser = User.getUserFromJsonObject(user)
                        GlobalData.loginUser = nowUser

                        val myIntent = Intent(mContext, MyPageActivity::class.java)
                        startActivity(myIntent)
                        finish()

                    }

                })





        }






        }, 2500)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
