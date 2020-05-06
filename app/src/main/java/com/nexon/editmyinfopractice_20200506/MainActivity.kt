package com.nexon.editmyinfopractice_20200506

import android.os.Bundle
import android.util.Log
import com.nexon.editmyinfopractice_20200506.datas.User
import com.nexon.editmyinfopractice_20200506.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

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

//      토큰을 가지고 사용자 정보 불러오기
//      User클래스 형태로 파싱 => 화면에 실제 본인의 정보를 표시하기
        ConnectServer.getRequestMyInfo(mContext, userToken, object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("사용자 정보", json.toString())
            }

        })

    }


}
