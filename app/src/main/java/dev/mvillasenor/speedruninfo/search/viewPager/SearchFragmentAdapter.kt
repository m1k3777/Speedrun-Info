package dev.mvillasenor.speedruninfo.ui.search.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dev.mvillasenor.speedruninfo.ui.search.GamesSearchFragment

class SearchFragmentAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return GamesSearchFragment()
    }

    override fun getCount(): Int = 2
}
