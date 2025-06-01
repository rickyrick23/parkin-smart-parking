package com.example.parkin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity(), ParkingSlotAdapter.OnSlotClickListener {

    private val slotList = mutableListOf(
        ParkingSlot(1, ParkingStatus.VACANT),
        ParkingSlot(2, ParkingStatus.OCCUPIED),
        ParkingSlot(3, ParkingStatus.VACANT),
        ParkingSlot(4, ParkingStatus.RESERVED),
        ParkingSlot(5, ParkingStatus.VACANT),
        ParkingSlot(6, ParkingStatus.OCCUPIED)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSlots)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ParkingSlotAdapter(slotList, this)
    }

    override fun onReserveClicked(slot: ParkingSlot, position: Int) {
        if (slot.status == ParkingStatus.VACANT) {
            slotList[position] = slot.copy(status = ParkingStatus.RESERVED)
            findViewById<RecyclerView>(R.id.recyclerViewSlots).adapter?.notifyItemChanged(position)
        }
    }
}

data class ParkingSlot(val number: Int, val status: ParkingStatus)
enum class ParkingStatus { OCCUPIED, VACANT, RESERVED }
