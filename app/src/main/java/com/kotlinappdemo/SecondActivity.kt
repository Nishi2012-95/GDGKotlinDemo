package com.kotlinappdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getFamousPlaces()
    }

    /*
    * use data class, get and set data into data class parameter
    * */
    fun getFamousPlaces() {
        val place1 = FamousPlace(1, "Taj Mahal", "Mumbai")

        place1.cityName = "Agra"

        println("Place Name:${place1.placeName} and City :${place1.cityName}")
        txtPlace1.text = "Place Name:${place1.placeName} and City :${place1.cityName}"

        val place2 = place1.copy(placeName = "Goldan Temple", cityName = "Amritsar")
        println("Place Name:${place2.placeName} and City :${place2.cityName}")
        txtPlace2.text = "Place Name:${place2.placeName} and City :${place2.cityName}"

    }
}
