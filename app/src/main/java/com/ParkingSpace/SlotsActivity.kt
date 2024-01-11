package com.ParkingSpace

import android.net.http.HttpException
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ParkingSpace.databinding.ActivitySlotsBinding
import okio.IOException
import java.lang.Exception
import java.net.HttpURLConnection

const val TAG = "SlotsActivity"

class SlotsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlotsBinding
    private lateinit var slotsAdapter: SlotsAdapter

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.slotProgressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getSlots()

            } catch (e:IOException) {
                Log.e(TAG, "IOException, Looks like you do not have a network connection ",)
                binding.slotProgressBar.isVisible=false

                return@launchWhenCreated

            } catch (e:HttpException){
                Log.e(TAG, "HttpException, Unexpected Response ",)
                binding.slotProgressBar.isVisible=false

                return@launchWhenCreated


            }
            if (response.isSuccessful && response.body()!= null){
                slotsAdapter.slots= response.body()!!

            }else{
                Log.e(TAG, "Response not successful")
            }
            binding.slotProgressBar.isVisible=false

        }
    }
    private fun setupRecyclerView() = binding.rvSlots.apply {
        slotsAdapter = SlotsAdapter()
        adapter = slotsAdapter
        layoutManager = LinearLayoutManager(this@SlotsActivity)
    }

}
