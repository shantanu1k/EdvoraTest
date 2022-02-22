package com.cowday.edvora.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.RideAdapter
import com.cowday.edvora.adapters.UpcomingAdapter
import com.cowday.edvora.data.Ride
import com.cowday.edvora.databinding.FragmentUpcomingBinding
import com.cowday.edvora.viewModels.UpcomingViewModel

class UpcomingFragment(private val rides: ArrayList<Ride>) : Fragment() {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: UpcomingViewModel
    private val adapter = UpcomingAdapter()
//    val rideList: ArrayList<Ride> = arrayListOf(
//        Ride(1,23, listOf(23, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
//        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1644924365,"url","Maharashtra","Panvel"),
//        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644673041,"url","Maharashtra","Panvel"),
//    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpcomingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpcomingViewModel::class.java)
        recyclerView = binding.recycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel._rideList.observe(viewLifecycleOwner, Observer {
            adapter.updateRideList(it)
        })
        val currentRides = arrayListOf<Ride>()
        for(i in rides){
//            if(i.date < currentTime){
                currentRides.add(i)
//            }
        }
        viewModel.addRides(currentRides)
    }


    companion object {
        @JvmStatic
        fun newInstance(rides: ArrayList<Ride>) =  UpcomingFragment(rides)
    }
}
