package com.example.api02.fragements

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val postListView: Any
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }


    abstract fun setupEvents()
    abstract fun setValues()


    }
