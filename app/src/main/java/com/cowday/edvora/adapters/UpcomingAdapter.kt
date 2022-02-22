package com.cowday.edvora.adapters

import android.annotation.SuppressLint
import android.icu.text.DateFormat.getTimeInstance
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.data.Ride
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.RideViewHolder>() {
    var rideList : ArrayList<Ride> = arrayListOf()
    class RideViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val id: TextView = itemView.findViewById(R.id.ride_id)
        val originStation: TextView = itemView.findViewById(R.id.origin_station)
        val stationPath: TextView = itemView.findViewById(R.id.station_path)
        val date: TextView = itemView.findViewById(R.id.date)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val city: TextView = itemView.findViewById(R.id.city_name)
        val state: TextView = itemView.findViewById(R.id.state_name)
    }
    //Updating the rides
    fun updateRideList(upcomingRideList: ArrayList<Ride>){
        rideList = upcomingRideList
        notifyDataSetChanged()
    }
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
        holder.apply {
            date.text = holder.date.text.toString()+ getDateTime(currentItem.date)
            distance.text = holder.distance.text.toString() + getMinDistance(currentItem.station_path,currentItem.originStationCode)
            city.text = currentItem.city
            state.text = currentItem.state
        }
    }
    override fun getItemCount(): Int = rideList.size
    // A function to get the distance between the origin station & the
    // nearest station from station_path array
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
    //Converting the unix epoch time to date-time format
    @SuppressLint("SimpleDateFormat")
    fun getDateTime(unixEpoch: Long): String{
        var dateTime = ""
        val date = Date(unixEpoch*1000)
        dateTime = SimpleDateFormat("d MMM yyyy HH:mm").format(date)
        return dateTime
    }
}