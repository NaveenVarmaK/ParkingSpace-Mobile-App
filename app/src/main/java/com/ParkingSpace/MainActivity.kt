package com.ParkingSpace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.SlotButton)
        button.setOnClickListener{
            openSlotsActivity()

        button = findViewById(R.id.YourBookingsButton)
        button.setOnClickListener {
            openYourBookings()
        }
        }
    }

    fun openSlotsActivity() {
        val intent = Intent(this, SlotsActivity::class.java)
        startActivity(intent)
    }
    fun openYourBookings() {
        val intent =Intent(this, YourBookings::class.java)
        startActivity(intent)


    }
}