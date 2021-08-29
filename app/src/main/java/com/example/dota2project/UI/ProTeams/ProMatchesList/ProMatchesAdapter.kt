package com.example.dota2project.UI.ProTeams.ProMatchesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2project.R
import com.example.dota2project.UI.ProMatches.ProMatches

class ProMatchesAdapter(val list: MutableList<ProMatches>, val fragment: ProMatchesFragment) :
    RecyclerView.Adapter<ProMatchesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var leagueName: TextView? = null
        var radiantName: TextView? = null
        var direName: TextView? = null
        var radiantScore: TextView? = null
        var direScore: TextView? = null
        var duration: TextView? = null
        var startTime: TextView? = null

        init {
            leagueName = itemView.findViewById(R.id.league_match_name)
            radiantName = itemView.findViewById(R.id.team_radiant_name)
            direName = itemView.findViewById(R.id.dire_name)
            radiantScore = itemView.findViewById(R.id.radiant_score)
            direScore = itemView.findViewById(R.id.dire_score)
            duration = itemView.findViewById(R.id.pro_match_duration)
            startTime = itemView.findViewById(R.id.pro_match_start_time)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProMatchesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.pro_match_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showMatch(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ProMatchesAdapter.ViewHolder, position: Int) {
        val proMatches: ProMatches = list[position]

        holder.leagueName?.text = list[position].league_name
        holder.radiantName?.text = list[position].radiant_name
        holder.radiantScore?.text = list[position].radiant_score.toString()
        holder.direScore?.text = list[position].dire_score.toString()
        holder.direName?.text = list[position].dire_name
        holder.duration?.text = list[position].duration.toString()
        holder.startTime?.text = list[position].start_time.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}