package com.example.api02.fragements

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api02.R
import com.example.api02.datas.Post
import com.example.api02.utils.ConnectSever
import org.json.JSONObject

class BoardFragment : BaseFragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    val posts=ArrayList<>()



    override fun setupEvents() {

    }

    override fun setValues() {



    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragement_board, container, false)


        fun getPostsFromSever(){

            ConnectSever.getRequestPostList(mContext, object :ConnectSever.JsonResponseHandler)
            override fun onResponse(json : JSONObject){
                //Log.d("게시글 목록", json.toString())


                val code=json.getInt("code")

                if(code==200){
                    val data=json.getJSONObject("data")
                    val blackLists=data.getJSONArray("black_lists")

                    //배열 : 10개=>0~9
                    for (i in 0..blackLists.length()-1){
                        val postJson=blackLists.getJSONObject(i)


                    }
                }

            }
        }

    }






}