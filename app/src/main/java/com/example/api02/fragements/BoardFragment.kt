package com.example.api02.fragements

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.api02.Adapters.PostAdapter
import com.example.api02.R
import com.example.api02.datas.Post
import com.example.api02.utils.ConnectSever
import org.json.JSONObject

class BoardFragment : BaseFragment() {

    lateinit var postAdapter: PostAdapter
    var posts = ArrayList<Post>()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }





    override fun setupEvents() {

    }

    override fun setValues() {

        postAdapter= PostAdapter(mContext, R.layout.post_list_item, posts)
        postListView.addapter=PostAdapter

        fun getPostsFromServer(){

        }



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

                        //게시글 Json=>Post형태로 변경
                        val postObject=Post.getPostFromJson(postJson)

                        //변경된 객체를 posts에 추가
                        posts.add(postObject)


                    }

                    activity?.runOnUiThread {
                        postAdapter.notifyDataSetChanged()
                    }


                    for (post in posts){
                        Log.d("게시글제목", post.title)
                    }
                }

            }
        }

    }






}