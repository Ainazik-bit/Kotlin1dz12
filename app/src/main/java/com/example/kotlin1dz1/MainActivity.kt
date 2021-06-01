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

class MainActivity : AppCompatActivity() {

    val resultCallback =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                if (result?.resultCode == Activity.RESULT_OK && result.data != null) {
                    val str = result.data!!.getStringExtra("result")
                    edit_text.setText(str)
                } else {
                    Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
                }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        openActivity()
//        getData()
        button.setOnClickListener(View.OnClickListener {
            openActivity()
        })
    }


    private fun openActivity() {

        if (edit_text.text.isNotEmpty()) {
            val intent = Intent(this, SecondActivity::class.java)
            val fromTextView = edit_text.text.toString()

            intent.putExtra("fromTextView", fromTextView)
            resultCallback.launch(intent)
        } else {
            Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
        }

    }


//    private fun getData(){
//        val intent = intent
//        val textSecond = intent.getStringExtra("fromMain")
//        text_view1.text = textSecond
//    }
}
