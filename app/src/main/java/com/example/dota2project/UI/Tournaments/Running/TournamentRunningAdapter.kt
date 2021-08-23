package com.example.dota2project.UI.Tournaments.Running

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.UI.Tournaments.Model.Tournaments
import kotlinx.android.synthetic.main.running_tournaments_item.view.*

class TournamentRunningAdapter(
    val list: MutableList<Tournaments>,
    val fragment: TournamentRunning,
) :
    RecyclerView.Adapter<TournamentRunningAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var begin_at: TextView
        var league_name: TextView
        var tournament_image: ImageView
        var prize_pool: TextView

        init {
            begin_at = itemView.findViewById(R.id.begin_at)
            league_name = itemView.findViewById(R.id.league_name)
            tournament_image = itemView.findViewById(R.id.tournament_image)
            prize_pool = itemView.findViewById(R.id.tournament_prizepool)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.running_tournaments_item, parent, false)
        val viewHolder = ViewHolder(itemView)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tournament: Tournaments = list[position]
        var date = tournament.begin_at.substring(0, 10)


        holder.begin_at.text = date
        date = list[position].begin_at
        holder.league_name.text = list[position].league.name
        holder.prize_pool.text = list[position].prizepool
        Glide.with(holder.itemView).load(tournament.league.image_url)
            .into(holder.itemView.tournament_image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}