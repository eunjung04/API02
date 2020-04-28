package com.example.api02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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

    }
}
