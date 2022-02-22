package com.cowday.edvora

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.cowday.edvora.data.Ride
import com.cowday.edvora.data.User
import com.cowday.edvora.ui.main.SectionsPagerAdapter
import com.cowday.edvora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var rideList: ArrayList<Ride> = arrayListOf(
        Ride(1,23, listOf(33, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1644924365,"url","Maharashtra","Panvel"),
        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = User(20,"cowDay","url")
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager,rideList)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        binding.username.text = user.name
    }

}