package com.cowday.edvora.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.data.Ride
import java.text.SimpleDateFormat

class PastAdapter: RecyclerView.Adapter<PastAdapter.RideViewHolder>() {
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
    fun updateRideList(rides: ArrayList<Ride>){
        rideList = rides
    }
    fun getRides():Int{
        return rideList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ride,parent,false)
        return RideViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: PastAdapter.RideViewHolder, position: Int) {
        val currentItem = rideList[position]
        holder.apply {
            id.text = holder.id.text.toString() + currentItem.id.toString()
            originStation.text = holder.originStation.text.toString() + currentItem.originStationCode.toString()
            stationPath.text = holder.stationPath.text.toString()+currentItem.station_path.toString()
        }
        val realTime = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG).format(currentItem.date)
        holder.apply {
            date.text = holder.date.text.toString()+ realTime.toString()
            distance.text = holder.distance.text.toString() + getMinDistance(currentItem.station_path,currentItem.originStationCode)
            city.text = currentItem.city
            state.text = currentItem.state
        }
    }
    override fun getItemCount(): Int = rideList.size
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

}