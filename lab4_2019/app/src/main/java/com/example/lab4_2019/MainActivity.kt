package com.example.lab4_2019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todolist= mutableListOf(
            Todo(R.drawable.a, "flower 1", false ),
            Todo(R.drawable.b, "flower 2", false ),
            Todo(R.drawable.c, "flower 3", true ),
            Todo(R.drawable.d, "flower 4", false ),
            Todo(R.drawable.e, "flower 5", true ),
            Todo(R.drawable.f, "flower 6", false ),
            Todo(R.drawable.g, "flower 7", false ),
            Todo(R.drawable.h, "flower 8", false ),
            Todo(R.drawable.i, "flower 9", false )

        )

        var adapter=TodoAdapter(todolist)
        rvTodos.adapter=adapter
        rvTodos.layoutManager= LinearLayoutManager(this)
    }
}
