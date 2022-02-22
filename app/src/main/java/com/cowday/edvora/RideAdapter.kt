package com.cowday.edvora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.data.Ride

class RideAdapter: RecyclerView.Adapter<RideAdapter.RideViewHolder>() {
    val station_path = listOf(20, 93, 39, 40, 42, 54, 63, 72, 88, 98)
    var rideList : ArrayList<Ride> = arrayListOf()
    class RideViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)  {
        val id: TextView = itemView.findViewById(R.id.ride_id)
        val originStation: TextView = itemView.findViewById(R.id.origin_station)
        val stationPath: TextView = itemView.findViewById(R.id.station_path)
        val date: TextView = itemView.findViewById(R.id.date)
        val distance: TextView = itemView.findViewById(R.id.distance)
    }
    fun updateRideList(ride: Ride){
        this.rideList.add(ride)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ride,parent,false)
        return RideViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RideViewHolder, position: Int) {
        val currentItem = rideList[position]
        holder.id.text = holder.id.text.toString() + currentItem.id.toString()
        holder.originStation.text = holder.originStation.text.toString() + currentItem.originStationCode.toString()
        holder.stationPath.text = holder.stationPath.text.toString()+currentItem.station_path.toString()
        holder.date.text = holder.date.text.toString()+ currentItem.date
        holder.distance.text = "0"
    }

    override fun getItemCount(): Int = rideList.size
}