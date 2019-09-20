package com.example.newsproject.ui.main.topheadlines

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.newsproject.R
import com.example.newsproject.adapters.NewsAdapter
import com.example.newsproject.models.News
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    var list = ArrayList<News>()
    lateinit var adapter : NewsAdapter
    lateinit var layoutManager : LinearLayoutManager
    lateinit var snapHelper: SnapHelper

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTopHeadlines()
        snapHelper = PagerSnapHelper()
        adapter = NewsAdapter(list)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsRV.adapter = adapter
        snapHelper.attachToRecyclerView(newsRV)
        newsRV.layoutManager = layoutManager
        viewModel.list.observe(this, Observer {
            list = viewModel.list.value!!
            adapter.updateList(list)
        })
    }

}
