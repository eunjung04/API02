package com.example.api02.utils

import android.content.Context
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ConnectSever {

    interface JsonResponseHandler {
        fun onResponse(json: JSONObject)
    }

        companion object {

            val BASE_URL = "http://192.168.0.243:5000"

            fun postRequestLogin(
                context: Context,
                id: String,
                pw: String,
                handler: JsonResponseHandler?
            ) {

                val client = OkHttpClient()
                //어떤 기능을 수행하러 가는지 주소 완성.
                //http://192.168.0.243:5000/auth
                val urlStr = "${BASE_URL}/auth"

                //서버에 들고갈 데이터를 첨부. =>POST메쏘드의 예제
                val formBody = FormBody.Builder()
                    .add("login_id", id)
                    .add("password", pw)
                    .build()


                //화면이동으로 따지면 Intent  객체를 만드는 행위.
                val request = Request.Builder()
                    .url(urlStr)
                    .post(formBody)
                    //.header()=>API가 헤더를 요구하면 추가해야함.
                    .build()

                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {

                        e.printStackTrace()
                    }

                    override fun onResponse(call: Call, response: Response) {


                        val body = response.body!!.string()
                        val json = JSONObject(body)

                        handler?.onResponse(json)

                        val code=json.getInt("code")

                        if(code==200) {
                            val data=json.getJSONObject("data")

                            val user=data.getJSONObject("user")
                            val token=data.getJSONObject("token")
                        }


                        else{

                            //서버에서 내려주는 메세지를 토스트로 출력
                            val message=json.getString("message")

                            runOnuiThread {

                                Toast.makeText()
                            }






                })

            }
        }
    }