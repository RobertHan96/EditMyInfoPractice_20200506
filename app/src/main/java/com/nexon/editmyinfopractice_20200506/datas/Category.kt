package com.nexon.editmyinfopractice_20200506.datas

import org.json.JSONObject

class Category {

    companion object {
        fun getCategoryFromJson(json: JSONObject) : Category {
            val ct = Category()
            ct.id = json.getInt("id")
            ct.title = json.getString("title")
            ct.color = json.getString("color")
            return ct
        }
    }
    var id = 0
    var title = ""
    var color = ""

//  포인터의 위치가 아닌, 카테고리의 ID값만 같아도 같다고 판단할 수 있도록 기준을 정하는 함수를 재정의
    override fun equals(other: Any?): Boolean {
        val otherCategory = other as Category
        return this.id == otherCategory.id
    }
}