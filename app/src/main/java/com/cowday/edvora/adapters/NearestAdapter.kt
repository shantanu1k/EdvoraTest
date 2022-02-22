package com.cowday.edvora.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.data.Ride

class NearestAdapter: RecyclerView.Adapter<NearestAdapter.RideViewHolder>() {
//    val station_path = listOf(20, 93, 39, 40, 42, 54, 63, 72, 88, 98)
    var minDistance = 0
    var rideList : ArrayList<Ride> = arrayListOf(
//        Ride(1,23, listOf(33, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
//        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1644924365,"url","Maharashtra","Panvel"),
//        Ride(3,13, listOf(16, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel")
    )
    class RideViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.ride_id)
        val originStation: TextView = itemView.findViewById(R.id.origin_station)
        val stationPath: TextView = itemView.findViewById(R.id.station_path)
        val date: TextView = itemView.findViewById(R.id.date)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val city: TextView = itemView.findViewById(R.id.city_name)
        val state: TextView = itemView.findViewById(R.id.state_name)
    }
    fun updateRideList(rides: ArrayList<Ride>){
        rideList = rides
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
        holder.distance.text = holder.distance.text.toString()+getMinDistance(currentItem.station_path,currentItem.originStationCode)
        holder.city.text = currentItem.city
        holder.state.text = currentItem.state
    }
    fun getMinDistance(stationPath:List<Int>,originStation: Int): Int{
        var minDis = 0
        var nearest: Int = 0
        for(i in stationPath){
            if(i>=originStation){
                nearest = i
                break
            }
        }
        minDis = nearest - originStation
        return minDis
    }
    override fun getItemCount(): Int = rideList.size
}