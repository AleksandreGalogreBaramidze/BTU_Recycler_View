package com.example.firebaserecycler.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserecycler.R
import com.exaple.firebaserecycler.data.Cars

class CarsRecyclerAdapter(private val userList : MutableList<Cars>) : RecyclerView.Adapter<CarsRecyclerAdapter.MyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.brandName.text = currentItem.brandName
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val brandName : TextView = itemView.findViewById(R.id.brandNameTextView)
    }
}