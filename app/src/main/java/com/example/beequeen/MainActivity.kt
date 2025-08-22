package com.beequeen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textViewHello)
        val button = findViewById<Button>(R.id.buttonClick)

        button.setOnClickListener {
            textView.text = "Бджілка знайдена! 👑"
        }
    }
}
