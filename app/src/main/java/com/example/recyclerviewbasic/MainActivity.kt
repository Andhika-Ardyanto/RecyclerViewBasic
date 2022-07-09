package com.example.recyclerviewbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasic.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val todos = mutableListOf(
            "bangun", "makan", "minum"
        )

        binding.btnNew.setOnClickListener {
            todos.add(binding.newText.text.toString())
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = todoAdapter(todos)

        recyclerView = binding.myRecycler

        recyclerView.apply {


            layoutManager = viewManager
            adapter = viewAdapter
        }


    }
}