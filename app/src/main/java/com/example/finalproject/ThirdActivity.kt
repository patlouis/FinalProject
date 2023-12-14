package com.example.finalproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThirdActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantList: ArrayList<Plant>
    private lateinit var plantAdapter: PlantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_homepage)

        // Initialize plantList
        plantList = ArrayList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize plantList
        plantList = ArrayList()

        plantList.add(Plant(R.drawable.image1, "Bat Flower"))
        plantList.add(Plant(R.drawable.image2, "Carrion Plant"))
        plantList.add(Plant(R.drawable.image3, "Chrysanthemum"))
        plantList.add(Plant(R.drawable.image4, "Coralberry Tree"))
        plantList.add(Plant(R.drawable.image5, "Crown Imperial"))
        plantList.add(Plant(R.drawable.image6, "False Sunflower"))
        plantList.add(Plant(R.drawable.image7, "Hibiscus"))
        plantList.add(Plant(R.drawable.image8, "Lobelia"))
        plantList.add(Plant(R.drawable.image9, "Oriental Poppy"))
        plantList.add(Plant(R.drawable.image10, "Periwinkle"))
        plantList.add(Plant(R.drawable.image11, "Purple Passion"))
        plantList.add(Plant(R.drawable.image12, "Red Valerian"))
        plantList.add(Plant(R.drawable.image13, "Snow-in-Summer"))
        plantList.add(Plant(R.drawable.image14, "Spiderwort"))
        plantList.add(Plant(R.drawable.image15, "Venus Fly Trap"))
        plantList.add(Plant(R.drawable.image16, "Woodland Phlox"))

        plantAdapter = PlantAdapter(plantList)
        recyclerView.adapter = plantAdapter
        getUserData()
    }

    private fun getUserData(){
        var adapter = PlantAdapter(plantList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PlantAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@ThirdActivity, "You Clicked on item no. $position",Toast.LENGTH_LONG).show()
            }

        })
    }
}
