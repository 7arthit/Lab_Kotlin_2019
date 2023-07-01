package com.example.lab6_1_2019

import java.util.Random

class StudentModel(var id:Int= getAutoId(), var name:String="", var email:String="")
{
    companion object
    {
        fun getAutoId():Int
        {
            var random=Random()
            return random.nextInt(100)
        }
    }
}