package com.android.desafiofinalstarwars.ui.home.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.desafiofinalstarwars.ui.home.fragments.SpeciesFragment
import com.android.desafiofinalstarwars.ui.home.fragments.CharactersFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> return CharactersFragment()
            1 -> return SpeciesFragment()
        }
        return CharactersFragment()
    }

}