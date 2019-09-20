package com.example.newsproject.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.newsproject.R
import com.example.newsproject.ui.main.everything.EverythingFragment
import com.example.newsproject.ui.main.sources.SourcesFragment
import com.example.newsproject.ui.main.topheadlines.MainFragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction().add(R.id.holderFrame, MainFragment.newInstance()).commitAllowingStateLoss()
        bottom_nav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.tab_top ->{
                    childFragmentManager.beginTransaction().replace(R.id.holderFrame, MainFragment.newInstance()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tab_everything -> {
                    childFragmentManager.beginTransaction().replace(R.id.holderFrame, EverythingFragment.newInstance()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tab_sources ->{
                    childFragmentManager.beginTransaction().replace(R.id.holderFrame, SourcesFragment.newInstance()).commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

}
