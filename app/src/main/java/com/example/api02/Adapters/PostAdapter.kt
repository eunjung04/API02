package com.example.api02.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.api02.datas.Post

class PostAdapter(context: Context, val resId : Int, list : ArrayList<Post>) : ArrayAdapter<Post>(context, resId, list) {

    val mContext=context
    val mList=list
    val inf=LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow=convertView
        tempRow?.let {
            //재사용할 뷰가 있는 경우

        }.let {
            //새로 그려줘야 하는 경우
            tempRow=inf.inflate(resId,null)
        }

        val row=tempRow!!

        return  row
    }

}