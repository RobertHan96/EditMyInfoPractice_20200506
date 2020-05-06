package com.nexon.editmyinfopractice_20200506

import android.os.Bundle
import android.util.Log

class MainActivity : BaseActivity() {
    lateinit var userToken : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

    }

    override fun setValues() {
        userToken = intent.getStringExtra("token")
        Log.d("유저 토큰", userToken)
    }


}
