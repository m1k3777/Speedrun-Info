package dev.mvillasenor.speedruninfo.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.mvillasenor.speedruninfo.databinding.FragmentSearchBinding
import dev.mvillasenor.speedruninfo.ui.search.viewPager.SearchFragmentAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pager.adapter = SearchFragmentAdapter(childFragmentManager)
    }
}
