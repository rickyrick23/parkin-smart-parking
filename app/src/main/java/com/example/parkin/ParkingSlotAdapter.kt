package com.example.parkin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ParkingSlotAdapter(
    private val slots: List<ParkingSlot>,
    private val listener: OnSlotClickListener
) : RecyclerView.Adapter<ParkingSlotAdapter.SlotViewHolder>() {

    interface OnSlotClickListener {
        fun onReserveClicked(slot: ParkingSlot, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_parking_slot, parent, false)
        return SlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlotViewHolder, position: Int) {
        val slot = slots[position]
        holder.bind(slot)
        holder.reserveButton.setOnClickListener {
            listener.onReserveClicked(slot, position)
        }
    }

    override fun getItemCount() = slots.size

    class SlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val slotNumber: TextView = itemView.findViewById(R.id.textSlotNumber)
        private val slotStatus: TextView = itemView.findViewById(R.id.textSlotStatus)
        val reserveButton: Button = itemView.findViewById(R.id.buttonReserve)

        fun bind(slot: ParkingSlot) {
            slotNumber.text = "Slot ${slot.number}"
            when (slot.status) {
                ParkingStatus.OCCUPIED -> {
                    slotStatus.text = "Occupied"
                    slotStatus.setBackgroundColor(Color.RED)
                    reserveButton.visibility = View.GONE
                }
                ParkingStatus.VACANT -> {
                    slotStatus.text = "Vacant"
                    slotStatus.setBackgroundColor(Color.GREEN)
                    reserveButton.visibility = View.VISIBLE
                }
                ParkingStatus.RESERVED -> {
                    slotStatus.text = "Reserved"
                    slotStatus.setBackgroundColor(Color.MAGENTA)
                    reserveButton.visibility = View.GONE
                }
            }
        }
    }
}
