package com.example.api02.utils

import android.content.Context
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ConnectSever {

    interface JsonResponseHandler {
        fun onResponse(json: JSONObject)

        companion object{

        val BASE_URL="http://192.168.0.243:5000"

        fun postRequestLogin(context: Context, id:String, pw:String, handler : JsonResponseHandler?){

            val client= OkHttpClient()
            //어떤 기능을 수행하러 가는지 주소 완성.
            //http://192.168.0.243:5000/auth
            val urlStr="${BASE_URL}/auth"

            //서버에 들고갈 데이터를 첨부. =>POST메쏘드의 예제
            val formBody= FormBody.Builder()
                .add("login_id", id)
                .add("password", pw)
                .build()


            //화면이동으로 따지면 Intent  객체를 만드는 행위.
            val request= Request.Builder()
                .url(urlStr)
                .post(formBody)
                //.header()=>API가 헤더를 요구하면 추가해야함.
                .build()
//startActivity 처럼 실제로 요청을 날리는 코드.
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //서버 연결 자체를 실패.

                    //연결에 실패한 경위를 로그로 출력
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {

                    //서버의 응답은 보통 JSON양식으로 가공되어 옴.
                    //받을때는 일단 String타입으로  받게 됨.=>JSON으로 변환해서 액티비티에 전달.

                    val body = response.body!!.string()
                    val json = JSONObject(body)

                    handler?.onResponse(json)

                }

            })

    }
}