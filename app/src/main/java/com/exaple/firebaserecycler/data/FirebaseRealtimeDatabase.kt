package com.exaple.firebaserecycler.data

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRealtimeDatabase(val context: Context) {

    private lateinit var databaseReference: DatabaseReference
    private var carsArray: MutableList<Cars> = mutableListOf()

    fun getCarDatabase(): MutableList<Cars> {
        databaseReference = FirebaseDatabase.getInstance().getReference("cars")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val cars = Cars(brandName = userSnapshot.value.toString())
                        carsArray.add(cars)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return carsArray
    }
}