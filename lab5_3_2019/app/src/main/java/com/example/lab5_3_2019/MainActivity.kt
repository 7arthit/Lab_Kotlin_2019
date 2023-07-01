package com.example.lab5_3_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragment=Fragment_m()
        val hFragment=Fragment_h()
        val pFragment=Fragment_p()
        val bottomNavigationItemView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationItemView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miMessage->setCurrentFragment(mFragment)
                R.id.miHome->setCurrentFragment(hFragment)
                R.id.miProfile->setCurrentFragment(pFragment)
            }
            true
        }
        bottomNavigationItemView.getOrCreateBadge(R.id.miMessage).apply {
            number=10
            isVisible=true
        }
    }
    private fun  setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            addToBackStack(null)
            commit()
        }
}