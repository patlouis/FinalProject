package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant)

        val plant = intent.getParcelableExtra<Plant>("plant")
        if(plant != null){
            val plantName : TextView = findViewById(R.id.plantNameTV)
            val plantDescription : TextView = findViewById(R.id.plantDescriptionTV)
            val plantImage : ImageView = findViewById(R.id.plantIV)

            plantName.text = plant.name
            plantDescription.text = plant.description
            plantImage.setImageResource(plant.image)
        }

        //Back button to plant list
        val backButton = findViewById<Button>(R.id.backBtn)

        backButton.setOnClickListener {
            val i = Intent(this, ThirdActivity::class.java)
            startActivity(i)
        }
    }
}