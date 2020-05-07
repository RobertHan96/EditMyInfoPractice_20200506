package com.nexon.editmyinfopractice_20200506

import android.os.Bundle
import android.util.Log
import com.nexon.editmyinfopractice_20200506.adapters.CategorySpinnerAdapter
import com.nexon.editmyinfopractice_20200506.datas.Category
import com.nexon.editmyinfopractice_20200506.datas.User
import com.nexon.editmyinfopractice_20200506.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {
    lateinit var userToken : String
    lateinit var categoryAdapter : CategorySpinnerAdapter
    val categoryList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

    }

    override fun setValues() {
        getCategoryFromServer()
        categoryAdapter = CategorySpinnerAdapter(mContext, R.layout.category_list_item, categoryList)
        categorySpinner.adapter = categoryAdapter

        userToken = intent.getStringExtra("token")
        Log.d("유저 토큰", userToken)

//      토큰을 가지고 사용자 정보 불러오기
//      User클래스 형태로 파싱 => 화면에 실제 본인의 정보를 표시하기
        ConnectServer.getRequestMyInfo(mContext, userToken, object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("사용자 정보", json.toString())
                val code = json.getInt("code")
                if (code == 200) {
                    val data = json.getJSONObject("data")
                    val user = data.getJSONObject("user")
                    val userObj = User.getUserFromJsonObject(user)

                    runOnUiThread {
                        idText.text = userObj.loginId
                        nameText.setText(userObj.name)
                        phoneNumText.setText(userObj.phoneNum)
                        memoText.setText(userObj.memo)
                        val printSdf = SimpleDateFormat("yyyy년 M월 d일 (E)")
                        createdAtText.text = printSdf.format(userObj.createdAt.time)

//                      현재 유저 객체의 카테고리 객체를 indexOf()메서드를 통해 호출하면 인덱스 위치를 알 수 있음
//                      해당 인덱스 위치를 바탕으로 마이페이지 진입시 실제 내 정보값을 드롭다운 메뉴에서 제대로 보여줄 수 있음
                        val index = categoryList.indexOf(userObj.category)
                        categorySpinner.setSelection(index)

                    }

                }
            }

        })

    }

    fun getCategoryFromServer() {
        ConnectServer.getRequestUserCategory(mContext, object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("category list ", json.toString())

                val code = json.getInt("code")
                if (code == 200) {
                    val data = json.getJSONObject("data")
                    val userCategories = data.getJSONArray("user_categories")

                    for (i in 0..userCategories.length()-1) {
                        val userCategory = userCategories.getJSONObject(i)
                        val categoryObj = Category.getCategoryFromJson(userCategory)
                        categoryList.add(categoryObj)
                    }
                    runOnUiThread{
                        categoryAdapter.notifyDataSetChanged()
                    }
                }
            }

        })
    }


}
