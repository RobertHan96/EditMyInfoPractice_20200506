package com.nexon.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
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
