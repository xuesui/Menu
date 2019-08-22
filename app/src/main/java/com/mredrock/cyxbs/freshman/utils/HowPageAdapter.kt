package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R


class HowPageAdapter(private val title: List<String>, fm: FragmentManager, private val fragments: List<Fragment>) :
        FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }


}

