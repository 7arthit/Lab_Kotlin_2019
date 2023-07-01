package com.example.lab5_2_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = Fragment1()
        val fragment2 = Fragment2()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFlagment, fragment1)
            commit()
        }
        val btf1 = findViewById<Button>(R.id.button1)
        val btf2 = findViewById<Button>(R.id.button2)

        btf1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFlagment,fragment1)
                addToBackStack(null)
                commit()
            }
        }
        btf2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFlagment,fragment2)
                addToBackStack(null)
                commit()
            }
        }
    }
}