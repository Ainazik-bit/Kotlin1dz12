package com.example.kotlin1dz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivity()
        getData()
    }
    private fun openActivity(){
        button.setOnClickListener(View.OnClickListener {
            if (edit_text.text.isNotEmpty()){
            val fromTextView = edit_text.text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
               putExtra("fromTextView", fromTextView) }
            startActivity(intent)
            }else{
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun getData(){
        val intent = intent
        val textSecond = intent.getStringExtra("fromMain")
        text_view1.text = textSecond
    }
}