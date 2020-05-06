package com.nexon.editmyinfopractice_20200506

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nexon.editmyinfopractice_20200506.datas.User
import com.nexon.editmyinfopractice_20200506.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
        loginBtn.setOnClickListener {
//            아이디 / 비번 받아서 => 서버에 로그인 요청

            val id = idEdt.text.toString()
            val pw = pwEdt.text.toString()


            ConnectServer.postRequestLogin(mContext, id, pw, object : ConnectServer.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {

                    Log.d("로그인응답", json.toString())

//                    val code = json.getInt("code")
//
//                    if (code == 200) {
//
//                        val data = json.getJSONObject("data")
//
//                        val user = data.getJSONObject("user")
//                        val token = data.getString("token")
//
//                        val nowLoginUser = User.getUserFromJsonObject(user)
//
//                        GlobalData.loginUser = nowLoginUser
//                        ContextUtil.setUserToken(mContext, token)
//
//                        val myIntent = Intent(mContext, MyPageActivity::class.java)
//                        startActivity(myIntent)
//
//                    }
//                    else {
//                        val message = json.getString("message")
//
//                        runOnUiThread {
//                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
//                        }
//
//                    }


                }

            })

        }
    }

    override fun setValues() {

    }


}
