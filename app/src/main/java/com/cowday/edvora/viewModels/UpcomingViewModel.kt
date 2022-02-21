package com.cowday.edvora.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cowday.edvora.data.Ride

class UpcomingViewModel: ViewModel() {
    private val rideList: MutableLiveData<ArrayList<Ride>> = MutableLiveData()
    val _rideList: LiveData<ArrayList<Ride>>
        get() =  rideList
    fun addRides(rides: ArrayList<Ride>){
        rideList.value = rides
    }
}