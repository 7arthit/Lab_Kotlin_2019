package com.example.demoactivity

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
        var c2=findViewById<CardView>(R.id.cardView)
        var b1=findViewById<Button>(R.id.button)
        var name=findViewById<EditText>(R.id.editName)

        c1.setOnClickListener{
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        c2.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        b1.setOnClickListener {
            val intent=Intent(this,DetailActivity::class.java)
            intent.putExtra("fullname",name.text.toString())
            startActivity(intent)
        }
    }
}