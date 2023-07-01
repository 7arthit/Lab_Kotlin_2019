package com.example.lab5_1_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact-> Toast.makeText(this,"You click add contact",Toast.LENGTH_LONG).show()
            R.id.miFavorite-> Toast.makeText(this,"You click add favorite",Toast.LENGTH_LONG).show()
            R.id.miFeedback-> Toast.makeText(this,"You click add feedback",Toast.LENGTH_LONG).show()
            R.id.miSetting-> Toast.makeText(this,"You click add setting",Toast.LENGTH_LONG).show()
            R.id.miClose->finish()
        }
        return true
    }
}