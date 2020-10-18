package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tv_result.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(STATE_RESULT, tv_result.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calculate) {
            val inputLength = edt_length.text.toString().trim()
            val inputWidth = edt_width.text.toString().trim()
            val inputHeight = edt_height.text.toString().trim()

            var isEmptyFields = false

            when {
                inputLength.isEmpty() -> {
                    edt_length.error = "Field ini tidak boleh kosong"
                    isEmptyFields = true
                }

                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    edt_width.error = "Field ini tidak boleh kosong"
                }

                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    edt_height.error = "Field ini tidak boleh kosong"
                }
            }


            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tv_result.text = volume.toString()
            }
        }
    }
}