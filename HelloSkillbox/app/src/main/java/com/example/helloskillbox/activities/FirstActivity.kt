package com.example.helloskillbox.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.helloskillbox.R
import kotlin.random.Random

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn = findViewById<Button>(R.id.btn_first)
        btn.setOnClickListener {
            onSecondScreenCalled()
        }
    }

    private fun onSecondScreenCalled() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("DATA_TEXT", "Hello, Skillbox, from First screen ${Random.nextInt(0,5)}")
        startActivity(intent)
    }
}