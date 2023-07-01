package com.example.demoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        var spMonth=findViewById<Spinner>(R.id.spMonths)
        val customList= listOf("one","two","three")
        val  adapter=ArrayAdapter<String>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)
        //spMonth.adapter=adapter
        spMonth.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity3,"You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
}