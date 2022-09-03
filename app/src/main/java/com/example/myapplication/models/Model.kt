package com.example.myapplication.models

// here inside brackets of class is constructor so when you create a object this constructor will called
// and you have to pass the values of variables present inside the constructor
data class Hobby(
    val title: String
)

//object deceleration is similar to static decelaration in java
object Supplier {

    val hobbies = listOf(
        Hobby("Swimming"),
        Hobby("Dancing"),
        Hobby("Writing"),
        Hobby("Drawing"),
        Hobby("Singing"),
        Hobby("coding"),
        Hobby("Swimming"),
        Hobby("Dancing"),
        Hobby("Writing"),
        Hobby("Drawing"),
        Hobby("Singing"),
        Hobby("coding"),
        Hobby("Swimming"),
        Hobby("Dancing"),
        Hobby("Writing"),
        Hobby("Drawing"),
        Hobby("Singing"),
        Hobby("coding")
    )


}