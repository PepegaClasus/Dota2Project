package tut.example.dota2Project.UI.ProTeams

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamsMatches
import java.text.SimpleDateFormat
import java.util.*

class ProTeamsInfoAdapter(val list: MutableList<ProTeamsMatches>, val fragment: TeamsInfoFragment) :
    RecyclerView.Adapter<ProTeamsInfoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var team_opposite_name: TextView? = null
        var league_name: TextView? = null
        var team_opposite_logo: ImageView? = null
        var start_time: TextView? = null
        var layout: ConstraintLayout? = null

        init {
            team_opposite_name = itemView.findViewById(R.id.opposite_team_name)
            league_name = itemView.findViewById(R.id.league_team_info_name)
            team_opposite_logo = itemView.findViewById(R.id.opposite_team_logo)
            start_time = itemView.findViewById(R.id.team_info_match_start_time)
            layout = itemView.findViewById(R.id.team_info_layout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.team_matches_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showMatches(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamMatches: ProTeamsMatches = list[position]
        val teamLogo = holder.itemView.findViewById<ImageView>(R.id.opposite_team_logo)
        holder.league_name?.text = teamMatches.league_name
        holder.team_opposite_name?.text = teamMatches.opposing_team_name
        Glide.with(holder.itemView).load(teamMatches.opposing_team_logo).into(teamLogo)

        if (teamMatches.radiant_win) {
            holder.layout?.setBackgroundColor(Color.GREEN)
        } else {
            holder.layout?.setBackgroundColor(Color.RED)
        }

        val simpleDateFormat = SimpleDateFormat("dd MM yyyy, HH:mm:ss", Locale.ENGLISH)
        val timeStart = teamMatches.start_time
        val finalTime = simpleDateFormat.format(timeStart * 1000L)
        holder.start_time?.text = finalTime
    }

    override fun getItemCount(): Int {
        return list.size
    }
}