package com.example.finalproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class ThirdActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantList: ArrayList<Plant>
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_homepage)

        // Initialize plantList
        plantList = ArrayList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        plantAdapter = PlantAdapter(plantList)
        recyclerView.adapter = plantAdapter
        // getUserData()

        searchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun addDataToList() {

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

    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<Plant>()
            val queryLowercase = query.lowercase(Locale.ROOT)

            for (i in plantList) {
                if (i.name.lowercase(Locale.ROOT).contains(queryLowercase)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
            } else {
                plantAdapter.setFilteredList(filteredList)
            }
        }
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