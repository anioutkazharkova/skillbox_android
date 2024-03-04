package com.example.helloskillbox.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.helloskillbox.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val text = intent.getStringExtra("DATA_TEXT")

        val textView = findViewById<TextView>(R.id.text_second)
        textView.text = text
    }
}