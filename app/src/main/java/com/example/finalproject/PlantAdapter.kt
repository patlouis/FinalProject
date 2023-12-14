package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter(private var plantList:ArrayList<Plant>)
    : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    var onItemClick : ((Plant) -> Unit)? = null

    class PlantViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        holder.imageView.setImageResource(plant.image)
        holder.textView.text = plant.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(plant)
        }
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun setFilteredList(plantList: ArrayList<Plant>) {
        this.plantList = plantList
        notifyDataSetChanged()
    }
}