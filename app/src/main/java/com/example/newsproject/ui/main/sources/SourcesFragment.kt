package com.example.newsproject.ui.main.sources

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.newsproject.R
import com.example.newsproject.adapters.SourceAdapter
import com.example.newsproject.models.Source
import kotlinx.android.synthetic.main.sources_fragment.*

class SourcesFragment : Fragment() {

    lateinit var adapter: SourceAdapter
    lateinit var layoutManager : LinearLayoutManager
    var sources = ArrayList<Source>()

    companion object {
        fun newInstance() = SourcesFragment()
    }

    private lateinit var viewModel: SourcesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sources_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SourcesViewModel::class.java)
        viewModel.getSources()
        adapter = SourceAdapter(sources)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        source_rv.adapter = adapter
        source_rv.layoutManager = layoutManager
        viewModel.sources.observe(this, Observer {
            sources = viewModel.sources.value!!
            adapter.updateList(viewModel.sources.value!!)
        })
    }

}
