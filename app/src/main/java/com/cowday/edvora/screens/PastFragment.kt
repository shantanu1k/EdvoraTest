package com.cowday.edvora.screens

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cowday.edvora.R
import com.cowday.edvora.RideAdapter
import com.cowday.edvora.adapters.PastAdapter
import com.cowday.edvora.data.Ride
import com.cowday.edvora.databinding.FragmentPastBinding
import com.cowday.edvora.viewModels.PastViewModel

class PastFragment(private val rides: ArrayList<Ride>) : Fragment() {
    private lateinit var binding: FragmentPastBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: PastViewModel
    private val adapter = PastAdapter()
//    val rideList: ArrayList<Ride> = arrayListOf(
//        Ride(1,23, listOf(23, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
//        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1644924365,"url","Maharashtra","Panvel"),
//        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel"),
//    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPastBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PastViewModel::class.java)
        recyclerView = binding.recycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        val currentTime = System.currentTimeMillis()
        viewModel._rideList.observe(viewLifecycleOwner, Observer {
            adapter.updateRideList(it)
        })
        viewModel.addRides(rides)
    }

    companion object {
        @JvmStatic
        fun newInstance(rides: ArrayList<Ride>) = PastFragment(rides)
    }
}