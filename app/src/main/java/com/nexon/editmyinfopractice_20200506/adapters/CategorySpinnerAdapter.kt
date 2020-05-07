package com.nexon.editmyinfopractice_20200506.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nexon.editmyinfopractice_20200506.R
import com.nexon.editmyinfopractice_20200506.datas.Category

class CategorySpinnerAdapter(val mContext : Context, val resId : Int, val mList : ArrayList<Category>) : ArrayAdapter<Category>(mContext, resId, mList) {
    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }
        val row = tempRow!!
        val colorImg = row.findViewById<ImageView>(R.id.colorImg)
        val categoryTitleText = row.findViewById<TextView>(R.id.categoryTitleText)
        val data = mList.get(position)

//      스트링값을 실제 색상코드로 변환해서 백그라운드 색상으로 적용하는 코드  
        colorImg.setBackgroundColor(Color.parseColor(data.color))
        categoryTitleText.text = data.title
        return  row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)

        }
        val row = tempRow!!
        val colorImg = row.findViewById<ImageView>(R.id.colorImg)
        val categoryTitleText = row.findViewById<TextView>(R.id.categoryTitleText)
        val data = mList.get(position)
        
        colorImg.setBackgroundColor(Color.parseColor(data.color))
        categoryTitleText.text = data.title
        return  row
    }
}
