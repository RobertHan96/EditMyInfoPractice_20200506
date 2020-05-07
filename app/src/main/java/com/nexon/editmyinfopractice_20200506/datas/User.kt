package com.nexon.editmyinfopractice_20200506.datas

import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class User {

    companion object {
        fun getUserFromJsonObject(json: JSONObject) : User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")
            parsedUser.category = Category.getCategoryFromJson(json.getJSONObject("category"))

            val createdAtStr = json.getString("created_at")
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            parsedUser.createdAt.time = sdf.parse(createdAtStr)
//          가일일시의 값을 Date타입으로 변환한 객체 삽입,
//            parsedUser.createdAt.set()

            return parsedUser
        }
    }

    var id = 0
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""
    var createdAt = Calendar.getInstance()
    var category = Category()

}