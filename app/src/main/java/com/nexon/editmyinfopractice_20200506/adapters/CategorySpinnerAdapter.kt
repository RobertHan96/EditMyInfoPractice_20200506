package com.nexon.editmyinfopractice_20200506.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
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


        return  row

    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)

        }
        val row = tempRow!!
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameText = row.findViewById<TextView>(R.id.nameText)
        val data = mList.get(position)
        nameText.text = data.name
        Glide.with(mContext).load(data.imgUrl).into(logoImg)

        return  row
    }
    }


}