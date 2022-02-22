package com.cowday.edvora.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.adapters.UpcomingAdapter
import com.cowday.edvora.data.Ride
import com.cowday.edvora.databinding.FragmentUpcomingBinding
import com.cowday.edvora.viewModels.UpcomingViewModel
import com.google.android.material.tabs.TabLayout


class UpcomingFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: UpcomingViewModel
    private val adapter = UpcomingAdapter()
    //Declaring the sample rides here for demonstration instead of getting them from api: https://assessment.api.vweb.app/rides
    //These rides are same for all three Nearest, Upcoming & Past fragments
    var rides: ArrayList<Ride> = arrayListOf(
        Ride(1,23, listOf(33, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1745625399,"url","Maharashtra","Panvel"),
        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel"),
    )
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
            if(i.date*1000 > System.currentTimeMillis()){
                currentRides.add(i)
            }
        }
        viewModel.addRides(currentRides)
    }


    companion object {
        @JvmStatic
        fun newInstance() =  UpcomingFragment()
    }
}
