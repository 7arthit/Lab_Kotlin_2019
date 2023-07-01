package com.example.lab3_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lab3_2019.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnClick.setOnClickListener {
            var inputName1 = viewBinding.FirstName.text
            var inputName2 = viewBinding.lastName.text
            var inputName3 = viewBinding.BirthDate.text
            var all:String= "$inputName1 $inputName2 $inputName3"
            Toast.makeText(applicationContext, all, Toast.LENGTH_LONG).show()
        }

            viewBinding.btnhide.setOnClickListener {
            viewBinding.group.visibility = View.GONE
        }

        viewBinding.btnshow.setOnClickListener {
            viewBinding.group.visibility = View.VISIBLE
        }

    }
}