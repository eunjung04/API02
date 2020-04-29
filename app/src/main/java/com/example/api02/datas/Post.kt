package com.example.api02.datas

import android.util.Log
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class Post {

    companion object{
        fun getPostFromJson(json : JSONObject) : Post {

            val p=Post()

            p.phoneNum=json.getString("phone_num")
            p.title=json.getString("title")
            p.content=json.getString("content")

            val userJson=json.getJSONObject("writer")
            p.writer=User.getUserFromJsonObject(userJson)





            //202001로 표시.=>출력할땐 항상 양식 가공.=>
            //val sdf=SimpleDateFormat("yymmdd")
            //Log.d("양식출력연습", sdf.format(p.created.time))



            //서버에서 주는 String=>p.createdAt(Calendar)로 변환 저장.
            val createdStr=json.getString("created_at")

            val sdf=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            p.created.time=sdf.parse(createdStr)




            return p

        }
    }

    var phoneNum=""
    var title=""
    var content=""

    var writer=User()
    var created=Calendar.getInstance()
}