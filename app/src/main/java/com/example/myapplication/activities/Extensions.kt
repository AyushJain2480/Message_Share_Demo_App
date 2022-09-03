package com.example.myapplication.activities


import android.content.Context
import android.widget.Toast

// give default values
fun Context.showToast(message : String , duration : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()

    normalFunction(5) // a will overriden a = 5
    normalFunction()

}
// default value is 2
fun normalFunction(a : Int = 2){

}