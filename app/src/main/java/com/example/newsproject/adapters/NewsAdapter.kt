package com.example.newsproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsproject.R
import com.example.newsproject.models.News

class NewsAdapter(var list : ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.NewsVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        return NewsVH(LayoutInflater.from(parent.context).inflate(R.layout.row_news, parent, false))
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list : ArrayList<News>){
        this.list = list
        notifyDataSetChanged()
    }


    class NewsVH(itemView : View) : RecyclerView.ViewHolder(itemView){
        var newsIV = itemView.findViewById<ImageView>(R.id.newsIV)
        var titleTV = itemView.findViewById<TextView>(R.id.titleTV)
        var descTV = itemView.findViewById<TextView>(R.id.descTV)

        fun bind(news : News){
            if(news.title!=null && news.urlToImage!=null && news.description!=null){
                titleTV.text = news.title
                descTV=null
                descTV.text = news.description
                Glide.with(itemView.context).load(news.urlToImage).into(newsIV)
            }
        }
    }
}