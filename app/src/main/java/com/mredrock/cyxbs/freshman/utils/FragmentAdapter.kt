package com.mredrock.cyxbs.freshman.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import java.util.ArrayList

class FragmentAdapter(fm: FragmentManager, private val fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}
