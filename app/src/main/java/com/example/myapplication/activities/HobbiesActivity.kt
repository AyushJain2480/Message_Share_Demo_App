package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.HobbiesAdapter
import com.example.myapplication.R
import com.example.myapplication.models.Supplier
import com.example.myapplication.databinding.ActivityHobbiesBinding

class HobbiesActivity : AppCompatActivity() {


    companion object{
        val TAG : String = HobbiesActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityHobbiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hobbies)
        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        // LinearLayoutManager because we want our recyclerView to appear in the vertical linear orientation
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)

        binding.recyclerView.adapter = adapter

    }
}
