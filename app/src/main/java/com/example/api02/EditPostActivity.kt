package com.example.api02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.api02.utils.ConnectSever
import kotlinx.android.synthetic.main.activity_edit_post.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class EditPostActivity : BaseActivity() {
    override fun setupEvents() {

        postCompleteBtn.setOnClickListener {
            val alert=AlertDialog.Builder(mContext)
            alert.setTitle("게시글 등럭")
            alert.setMessage("게시글을 등록 하시겠습니까?")
            alert.setPositiveButton("확인"{dia})
        }

        fun PostRequestBlackList{


        }
    }

        companion object {

            val BASE_URL = "http://192.168.0.243:5000"

            fun postRequestLogin(
                context: Context,
                id: String,
                pw: String,
                handler: ConnectSever.JsonResponseHandler?
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


                    }


                })

            }
    }

    override fun setValue() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_post)
        setValue()
        setupEvents()




    }
}
