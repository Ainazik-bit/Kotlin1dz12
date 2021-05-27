package com.example.kotlin1dz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getData()
        openMain()
    }
    private fun getData(){
        val intent = intent
        val textMain = intent.getStringExtra("fromTextView")
        text_view.text = textMain
    }
    private fun openMain(){
        button2.setOnClickListener(View.OnClickListener {
            if (edit_text2.text.isNotEmpty()){
                val fromMain = edit_text2.text.toString()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fromMain", fromMain) }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            }

        })
    }
}