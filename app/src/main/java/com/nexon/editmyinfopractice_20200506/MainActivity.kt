package com.nexon.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
//      아래와 같이 spinner의 값을 선택하기만해도 값을  가져올수 있긴하지만, 권장하지 않음
//      뷰가 로드되자마자 0번째 인덱스가 선택된것으로 인식되서 원하는 값을 가져올수 없기 때문
        jobSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("포지션", "${position} item is clicked")
            }

        }

        okBtn.setOnClickListener {
            val selectedJob =  jobSpinner.selectedItem as String
            Log.d("Selected Job ", selectedJob)

            val selectedPostion = jobSpinner.selectedItemPosition
            Log.d("Selected Position ", "${selectedPostion}")

        }

    }

    override fun setValues() {

    }

}
