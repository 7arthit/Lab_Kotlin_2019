package com.example.lab6_1_2019

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context):
SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION)
{
    companion object{
        private const val DATABASE_NAME = "student.db"
        private const val DATABASE_VERSION = 1
        private const val TBL_STUDENT = "tbl_student"
        private const val ID = "id"
        private const val NAME = "name"
        private const val EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblStudent=("CREATE TABLE " + TBL_STUDENT +"("
                + ID +" INTEGER PRIMARY KEY,"
                + NAME +" TEXT,"
                + EMAIL +" TEXT"+")")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_STUDENT")
        onCreate(db)
    }

    fun insertStudent(std:StudentModel):Long{
        val db = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(ID,std.id)
        contentValue.put(NAME,std.name)
        contentValue.put(EMAIL,std.email)
        
        val succes = db.insert(TBL_STUDENT,null,contentValue)
        db.close()
        return succes
    }

    fun getAllStudent():ArrayList<StudentModel>{
        val liststd:ArrayList<StudentModel> = ArrayList()

        val selectQuery = "SELECT * FROM $TBL_STUDENT"

        val db=this.readableDatabase

        val cursor:Cursor?

        try{
            cursor=db.rawQuery(selectQuery,null)
        } catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id:Int
        var name:String
        var email:String

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val std = StudentModel(id=id,name=name,email=email)
                liststd.add(std)
            } while(cursor.moveToNext())
        }
        return liststd
    }

    fun updateStudent(std:StudentModel):Int{
        val db = this.writableDatabase
        val contentValue=ContentValues()

        contentValue.put(ID,std.id)
        contentValue.put(NAME,std.name)
        contentValue.put(EMAIL,std.email)

        val succes = db.update(TBL_STUDENT,contentValue,"id="+std.id,null)
        db.close()
        return succes
    }

    fun deleteStudent(id:Int):Int{
        val db = this.writableDatabase

        var success = db.delete(TBL_STUDENT,"id=$id",null)
        db.close()
        return success
    }
}
