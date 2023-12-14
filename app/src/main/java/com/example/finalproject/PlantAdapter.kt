package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter(private var plantList:ArrayList<Plant>)
    : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private lateinit var  mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    inner class PlantViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) { // (itemView:View, listener: onItemClickListener)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)

        /* init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
       */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        holder.imageView.setImageResource(plant.image)
        holder.textView.text = plant.name
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun setFilteredList(plantList: ArrayList<Plant>) {
        this.plantList = plantList
        notifyDataSetChanged()
    }
}