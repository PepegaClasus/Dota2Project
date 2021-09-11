package tut.example.dota2Project.UI.ProTeams

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamPlayers

class TeamPlayersAdapter(val list: MutableList<ProTeamPlayers>, val fragment: TeamsInfoFragment) :
    RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var games: TextView? = null
        var wins: TextView? = null
        var inTeam: TextView? = null
        var notInTeam: TextView? = null

        init {
            name = itemView.findViewById(R.id.playerTeam_name)
            games = itemView.findViewById(R.id.games)
            wins = itemView.findViewById(R.id.wins)
            inTeam = itemView.findViewById(R.id.in_team)
            notInTeam = itemView.findViewById(R.id.leave)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TeamPlayersAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.team_players_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showPlayers(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: TeamPlayersAdapter.ViewHolder, position: Int) {
        val teamPlayers: ProTeamPlayers = list[position]
        holder.name?.text = teamPlayers.name
        holder.games?.text = teamPlayers.games_played.toString()
        holder.wins?.text = teamPlayers.wins.toString()

        if (teamPlayers.is_current_team_member) {
            holder.inTeam?.isVisible = true
            holder.notInTeam?.isVisible = false
            holder.inTeam?.setTextColor(Color.GREEN)
        } else {
            holder.inTeam?.isVisible = false
            holder.notInTeam?.isVisible = true
            holder.notInTeam?.setTextColor(Color.RED)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}