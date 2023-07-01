package com.example.lab6_1_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    private lateinit var recyelerViwe: RecyclerView
    private lateinit var sqLiteHelper: SQLiteHelper

    private var adapter: StudentAdapter? = null
    private var std:StudentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViwe()
        initRecycleViwe()
        sqLiteHelper = SQLiteHelper(this)
        btnAdd.setOnClickListener {
            addStudent()
        }
        btnView.setOnClickListener {
            getStudent()
        }
        adapter?.setOnClickItem {
            edName.setText(it.name)
            edEmail.setText(it.email)
            std=it
        }
        btnUpdate.setOnClickListener {
            updateStudent()
        }
        adapter?.setOnClickDeleteItem {
            deleteStudent(it.id)
        }
    }
    private fun deleteStudent(id:Int){
        val builder= AlertDialog.Builder(this)
        builder.setMessage("Are you sure want to delete item?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){dialog,_->
            sqLiteHelper.deleteStudent(id)
            getStudent()
            dialog.dismiss()
        }
        builder.setNegativeButton("No"){dialog,_->
            dialog.dismiss()
        }
        val alert=builder.create()
        alert.show()
    }
    private fun updateStudent(){
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if(name == std?.name && email == std?.email) {
            return
        }
        if(std == null)return

        val std = StudentModel(id= std!!.id,name= name,email= email)
        val status = sqLiteHelper.updateStudent(std)

        if(status>-1) {
            Toast.makeText(this,"Update",Toast.LENGTH_LONG).show()
            getStudent()
        } else {
            Toast.makeText(this,"no Update",Toast.LENGTH_LONG).show()
        }
    }
    private fun addStudent(){
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if(name.isEmpty()||email.isEmpty()) {
            Toast.makeText(this,"Input!!!!",Toast.LENGTH_LONG).show()
        } else {
            val std = StudentModel(name=name, email = email)
            val status = sqLiteHelper.insertStudent(std)

            if(status>-1) {
                Toast.makeText(this,"Add",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"no Save",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun getStudent() {
        val lisstd = sqLiteHelper.getAllStudent()
        adapter?.addItem(lisstd)
    }

    private fun initRecycleViwe() {
        recyelerViwe.layoutManager=LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyelerViwe.adapter = adapter
    }

    fun initViwe() {
        edName = findViewById(R.id.name)
        edEmail = findViewById(R.id.email)
        btnAdd = findViewById(R.id.btadd)
        btnView = findViewById(R.id.btview)
        btnUpdate = findViewById(R.id.btUpdate)
        recyelerViwe = findViewById(R.id.recycleView)
    }
}