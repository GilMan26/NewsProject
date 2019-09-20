package com.example.newsproject.ui.main.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.newsproject.R
import com.example.newsproject.models.News

class NewsDetailFragment : Fragment() {

    companion object {

        fun newInstance(news : News) : NewsDetailFragment{
            var mBundle = Bundle()
            mBundle.putParcelable("data", news)
            val fragment =  NewsDetailFragment()
            fragment.arguments = mBundle
            return fragment
        }

    }

    private lateinit var viewModel: NewsDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(NewsDetailViewModel::class.java)
        return inflater.inflate(R.layout.news_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
