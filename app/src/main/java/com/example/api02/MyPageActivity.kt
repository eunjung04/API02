package com.example.api02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api02.datas.GlobalData
import kotlinx.android.synthetic.main.activity_my_page.*

class MyPageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValue()
    }

    override fun setupEvents() {

    }

    override fun setValue() {

        nameTxt.text=GlobalData.loginUser?.name
        phoneTxt.text=GlobalData.loginUser?.phoneNum

    }
}
