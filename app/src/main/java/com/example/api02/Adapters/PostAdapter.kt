package com.example.api02.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.api02.R
import com.example.api02.datas.Post
import kotlinx.android.synthetic.main.post_list_item.view.*
import java.text.SimpleDateFormat

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

        val titleTxt=row.findViewById<TextView>(R.id.titleTxt)
        val writeTxt=row.findViewById<TextView>(R.id.writeTxt)
        val createdTxt=row.findViewById<TextView>(R.id.createdTxt)
        val phoneNum=row.findViewById<TextView>(R.id.phoneNum)

        val postDate=mList.get(position)

        titleTxt.text=postDate.title
        phoneNum.text="(${postDate.phoneNum}"
        writeTxt.text=("${postDate.writer.name}")


        val sdf=SimpleDateFormat("yyyy-mm-dd")
        createdTxt.text=sdf.format(postDate.created.time)

        return  row
    }

}