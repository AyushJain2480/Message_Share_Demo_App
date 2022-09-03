package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.AppConstants
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
                        // = "MainActivity"
        val TAG : String = MainActivity::class.java.simpleName
    }


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {

            Log.i(TAG,"button was clicked")

        showToast(resources.getString(R.string.btn_was_clicked) , Toast.LENGTH_LONG)
        }

        binding.sendData.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val message = binding.userMsg.text.toString()
            intent.putExtra(AppConstants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        binding.implicitShare.setOnClickListener {
            // we dont have to pass the parameter in Intent because we are not sure
            // in which activity we hav to send the data
            val intent = Intent()
            intent.action = Intent.ACTION_SEND

            //sending this message to other applications i.e implicit intent
            val message: String = binding.userMsg.text.toString()

            //These are pre defined keys which are known to other applications like whatsapp and facebook
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please select app : "))

        }

        binding.recviewId.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)


        }

    }
}
