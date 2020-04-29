package com.example.api02.datas

import org.json.JSONObject
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


            return p

        }
    }

    var phoneNum=""
    var title=""
    var content=""

    var writer=User()
    var created=Calendar.getInstance()
}