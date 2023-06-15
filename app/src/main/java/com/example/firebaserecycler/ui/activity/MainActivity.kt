package com.example.firebaserecycler.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserecycler.R
import com.example.firebaserecycler.ui.adapter.CarsRecyclerAdapter
import com.exaple.firebaserecycler.data.Cars
import com.exaple.firebaserecycler.data.FirebaseRealtimeDatabase


class MainActivity : ComponentActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.mainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarsRecyclerAdapter(getUserData())
    }

    private fun getUserData(): MutableList<Cars> {
        val firebaseRealtimeDatabaseObj = FirebaseRealtimeDatabase(this)
        return firebaseRealtimeDatabaseObj.getCarDatabase()
    }

}