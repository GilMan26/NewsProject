package com.example.newsproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.R
import com.example.newsproject.models.Source

class SourceAdapter(var list : ArrayList<Source>) : RecyclerView.Adapter<SourceAdapter.SourceVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceVH {
        return SourceVH(LayoutInflater.from(parent.context).inflate(R.layout.row_source, parent, false))
    }

    override fun onBindViewHolder(holder: SourceVH, position: Int) {
        holder.bind(list[position])
        Log.d("data", list[position].name)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list : ArrayList<Source>){
        this.list = list
        notifyDataSetChanged()
    }

    class SourceVH (itemView : View): RecyclerView.ViewHolder(itemView){
        var titleTV =itemView.findViewById<TextView>(R.id.source_name_tv)

        fun bind(source: Source){
            titleTV.text = source.name
        }
    }
}