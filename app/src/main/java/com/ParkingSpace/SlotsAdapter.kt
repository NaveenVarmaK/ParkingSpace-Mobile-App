package com.ParkingSpace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ParkingSpace.databinding.ItemSlotsBinding

class SlotsAdapter : RecyclerView.Adapter<SlotsAdapter.SlotsViewHolder>() {
    inner class SlotsViewHolder(val binding: ItemSlotsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Slots>() {
        override fun areItemsTheSame(oldItem: Slots, newItem: Slots): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Slots, newItem: Slots): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var slots: List<Slots>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun getItemCount()= slots.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotsViewHolder {
        return SlotsViewHolder(ItemSlotsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: SlotsViewHolder, position: Int) {
        holder.binding.apply {
            val slot = slots[position]
            txtStreetValue.text=slot.street
            txtAreaValue.text=slot.area
        }
    }


}