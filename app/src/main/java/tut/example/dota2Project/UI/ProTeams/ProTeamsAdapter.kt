package tut.example.dota2Project.UI.ProTeams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.ProTeams.Model.ProTeams

class ProTeamsAdapter(val list: MutableList<ProTeams>, val fragment: ProTeamsFragment) :
    RecyclerView.Adapter<ProTeamsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var team_name: TextView? = null
        var team_rank: TextView? = null
        var team_image: ImageView? = null

        init {
            team_name = itemView.findViewById(R.id.team_name)
            team_rank = itemView.findViewById(R.id.team_rank)
            team_image = itemView.findViewById(R.id.team_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.teams_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showTeamInfo(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team_image = holder.itemView.findViewById<ImageView>(R.id.team_image)
        val proTeams: ProTeams = list[position]
        holder.team_name?.text = proTeams.name
        holder.team_rank?.text = proTeams.rating.toString()

        Glide.with(holder.itemView).load(proTeams.logo_url).into(team_image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}