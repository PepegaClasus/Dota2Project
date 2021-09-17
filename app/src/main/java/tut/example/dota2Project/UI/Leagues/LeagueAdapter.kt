package tut.example.dota2Project.UI.Leagues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Leagues.Model.League

class LeagueAdapter(val list: MutableList<League>, val fragment: LeaguesFragment) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var league_name: TextView? = null
        var league_banner: ImageView? = null
        var league_tier: TextView? = null

        init {
            league_name = itemView.findViewById(R.id.league_name)
            league_banner = itemView.findViewById(R.id.league_banner)
            league_tier = itemView.findViewById(R.id.league_tier)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.league_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showLeagueInfo(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: LeagueAdapter.ViewHolder, position: Int) {
        val leagues: League = list[position]
        val banner = holder.itemView.findViewById<ImageView>(R.id.league_banner)
        holder.league_name?.text = leagues.name
        holder.league_tier?.text = leagues.tier
        Glide.with(holder.itemView).load(leagues.banner).into(banner)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}