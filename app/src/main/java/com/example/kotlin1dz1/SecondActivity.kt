package com.example.kotlin1dz1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getData()
//        openMain()
        button2.setOnClickListener(View.OnClickListener {
            openMain()
            //Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
        })
    }
    private fun getData(){
        val text = intent.getStringExtra("fromTextView")
        text_view.setText(text)
    }
    private fun openMain(){
        if (edit_text2.text.isNotEmpty()){
            intent.putExtra("result", edit_text2.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        else{
            Toast.makeText(this, "pole ne mojet byt pusty", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }
}