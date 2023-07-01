package com.example.demoactivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var showname=findViewById<TextView>(R.id.showName)
        var intent=intent
        showname.text=intent.getStringExtra("fullname")
    }
}