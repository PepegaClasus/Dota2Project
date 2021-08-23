package com.example.dota2project.UI.Players.ProPlayers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.ProPlayers
import kotlinx.android.synthetic.main.pro_players_item.view.*

class ProPlayerAdapter(val list: MutableList<ProPlayers>, val fragment: ProPlayersFragment) :
    RecyclerView.Adapter<ProPlayerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var proPlayerAvatar: ImageView
        var proPlayerName: TextView
        var last_match_time: TextView
        var fantasy_role: TextView
        var team_name: TextView

        init {
            proPlayerAvatar = itemView.findViewById(R.id.pro_players_image)
            proPlayerName = itemView.findViewById(R.id.pro_player_name)
            last_match_time = itemView.findViewById(R.id.pro_player_last_time)
            fantasy_role = itemView.findViewById(R.id.fantasy_role)
            team_name = itemView.findViewById(R.id.pro_player_team_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.pro_players_item, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val proPlayers: ProPlayers = list[position]
        var date = proPlayers.last_match_time.substring(0, 10)


        holder.last_match_time.text = date
        date = list[position].last_match_time
        holder.proPlayerName.text = list[position].personaname
        holder.team_name.text = list[position].team_name

        if (proPlayers.fantasy_role == 1) {
            holder.fantasy_role.text = "Carry"
        } else if (proPlayers.fantasy_role == 2) {
            holder.fantasy_role.text = "Mid"
        } else if (proPlayers.fantasy_role == 3) {
            holder.fantasy_role.text = "Offlane"
        } else if (proPlayers.fantasy_role == 4) {
            holder.fantasy_role.text = "Semi-Support"
        } else if (proPlayers.fantasy_role == 5) {
            holder.fantasy_role.text = "Support"
        }

        Glide.with(holder.itemView).load(proPlayers.avatarfull)
            .into(holder.itemView.pro_players_image)


    }


    override fun getItemCount(): Int {
        return list.size
    }
}