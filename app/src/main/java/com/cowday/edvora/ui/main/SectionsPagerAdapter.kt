package com.cowday.edvora.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cowday.edvora.R
import com.cowday.edvora.data.Ride
import com.cowday.edvora.screens.NearestFragment
import com.cowday.edvora.screens.PastFragment
import com.cowday.edvora.screens.UpcomingFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, private val rideList: ArrayList<Ride>) :
    FragmentPagerAdapter(fm) {
//    val rideList: ArrayList<Ride> = arrayListOf(
//        Ride(1,23, listOf(23, 42, 45, 48, 56, 60, 77, 81, 93),93,1644924365,"url","Maharashtra","Panvel"),
//        Ride(2,20, listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),98,1744924365,"url","Maharashtra","Panvel"),
//        Ride(3,13, listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),91,1644924365,"url","Maharashtra","Panvel"),
//    )
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = NearestFragment.newInstance(rideList)
            1 -> fragment = UpcomingFragment.newInstance(rideList)
            2 -> fragment = PastFragment.newInstance(rideList)
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }


    override fun getCount(): Int {
        return 3
    }
}