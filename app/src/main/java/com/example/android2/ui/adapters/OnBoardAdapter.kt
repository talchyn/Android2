package com.example.android2.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android2.ui.fragments.onboard.main.MainOnBoardFragment

class OnBoardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = MainOnBoardFragment().apply {
        arguments = Bundle().apply {
            putInt(MainOnBoardFragment.AGE_ONBOARD_PAGE_POSITION, position)
        }
    }
}