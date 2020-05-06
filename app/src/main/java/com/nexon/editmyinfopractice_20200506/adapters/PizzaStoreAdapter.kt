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
import com.nexon.editmyinfopractice_20200506.datas.PizzaStore

class PizzaStoreAdapter(val mContext : Context, resId : Int, val mList : ArrayList<PizzaStore>) : ArrayAdapter<PizzaStore>(mContext, resId, mList) {
    val inf = LayoutInflater.from(mContext)

//  스피너 아이템 선택전에 화면에 보여지는 디폴트 화면을 그리는 함수 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_item, null)

        }
        val row = tempRow!!
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameText = row.findViewById<TextView>(R.id.nameText)
        val data = mList.get(position)
        nameText.text = data.name
        Glide.with(mContext).load(data.imgUrl).into(logoImg)

        return  row
    }

//  스피너 아이템 리스트(드롭다운)에 노출될 각 아이템의 모양을 그리는 함수 부분
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_spinner_item, null)

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