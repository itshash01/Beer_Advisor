package com.hfad.beeradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem
            val beerList = getBeers(color.toString())
            val beers = beerList.reduce {str, item -> str + '\n' + item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf<String>("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf<String>("Jack Amber", "Red Moose")
            "Brown" -> listOf<String>("Brown Bear Beer", "Brock Brownie")
            else -> listOf<String>("Gout Stout", "Dark Daniel")
        }
    }
}