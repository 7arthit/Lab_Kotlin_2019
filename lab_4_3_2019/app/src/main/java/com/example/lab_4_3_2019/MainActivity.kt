package com.example.lab_4_3_2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c1=findViewById<CardView>(R.id.C1)
        var b1=findViewById<Button>(R.id.button)
        var name=findViewById<EditText>(R.id.editName)
        c1.setOnClickListener{
            val intent= Intent(this,DetailActivity::class.java)
            intent.putExtra("fullname","")
            startActivity(intent)
        }
        b1.setOnClickListener {
            val intent=Intent(this,DetailActivity::class.java)
            intent.putExtra("fullname",name.text.toString())
            startActivity(intent)
        }
    }
}
