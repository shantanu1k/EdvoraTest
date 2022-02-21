package com.cowday.edvora.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.data.Ride
import java.text.SimpleDateFormat

class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.RideViewHolder>() {
    var rideList : ArrayList<Ride> = arrayListOf(
//        Ride(1,23, listOf(23, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
//        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1744924365,"url","Maharashtra","Panvel"),
//        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel"),
    )
    init{
        updateRideList(rideList)
    }
    class RideViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val id: TextView = itemView.findViewById(R.id.ride_id)
        val originStation: TextView = itemView.findViewById(R.id.origin_station)
        val stationPath: TextView = itemView.findViewById(R.id.station_path)
        val date: TextView = itemView.findViewById(R.id.date)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val city: TextView = itemView.findViewById(R.id.city_name)
        val state: TextView = itemView.findViewById(R.id.state_name)
    }
    fun updateRideList(upcomingRideList: ArrayList<Ride>){
        rideList = upcomingRideList
        notifyDataSetChanged()
    }
    fun getRides() = rideList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ride,parent,false)
        return RideViewHolder(itemView)
    }
    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: UpcomingAdapter.RideViewHolder, position: Int) {
        val currentItem = rideList[position]
        holder.apply {
            id.text = holder.id.text.toString() + currentItem.id.toString()
            originStation.text = holder.originStation.text.toString() + currentItem.originStationCode.toString()
            stationPath.text = holder.stationPath.text.toString()+currentItem.station_path.toString()
        }
        val realTime = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG).format(currentItem.date)
        holder.apply {
            date.text = holder.date.text.toString()+ realTime.toString()
            distance.text = holder.distance.text.toString() + "0"
            city.text = currentItem.city
            state.text = currentItem.state
        }
    }

    override fun getItemCount(): Int = rideList.size

}