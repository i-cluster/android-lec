package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.myButton)
        val textView = findViewById<TextView>(R.id.myText)
        var peopleCount = 0
        button.setOnClickListener {
            peopleCount += 1

            textView.text = peopleCount.toString()
            Toast.makeText(this, "It's toast", Toast.LENGTH_LONG).show()
        }
    }
}