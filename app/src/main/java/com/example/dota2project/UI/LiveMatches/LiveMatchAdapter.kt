package com.example.dota2project.UI.LiveMatches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2project.R

class LiveMatchAdapter (val list: MutableList<LiveMatch>, val fragment:LiveMatchFragment):RecyclerView.Adapter<LiveMatchAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var radiantScore: TextView? = null
        var direScore:TextView? = null
        var match_time:TextView? = null
        var averageMMR:TextView? = null

        init {
            radiantScore = itemView.findViewById(R.id.live_radiant_score)
            direScore = itemView.findViewById(R.id.live_dire_score)
            match_time = itemView.findViewById(R.id.live_pro_match_duration)
            averageMMR = itemView.findViewById(R.id.live_average_mmr)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.live_match_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showMatchInfo(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val liveMatches:LiveMatch = list[position]

        holder.direScore?.text = liveMatches.dire_score.toString()
        holder.radiantScore?.text = liveMatches.radiant_score.toString()
        holder.averageMMR?.text = liveMatches.average_mmr.toString()

        var time = liveMatches.game_time
        val minutes = time.div(60)
        time = time.rem(60)
        val seconds = time
        if (seconds >= 10) {
            val timeString = "$minutes:$seconds"
            holder.match_time?.text = timeString
        } else {
            val timeString = "$minutes:0$seconds"
            holder.match_time?.text = timeString
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}