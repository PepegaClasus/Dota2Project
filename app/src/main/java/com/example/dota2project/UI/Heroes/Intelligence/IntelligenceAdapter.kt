package com.example.dota2project.UI.Heroes.Intelligence

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.Heroes
import kotlinx.android.synthetic.main.heroes_item.view.*

class IntelligenceAdapter(val list: MutableList<Heroes>, val fragment: IntList) :
    RecyclerView.Adapter<IntelligenceAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView


        init {
            name = itemView.findViewById(R.id.hero_name)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].localized_name
        val heroes: Heroes = list[position]
        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}