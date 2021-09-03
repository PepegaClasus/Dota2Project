package tut.example.dota2Project.UI.Players.FindPlayers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.players_search_item.view.*
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Players.FindPlayers.Model.PlayersSearch

class FindPlayersAdapter(val list: MutableList<PlayersSearch>, val fragment: FindPlayersFragment) :
    RecyclerView.Adapter<FindPlayersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var player_image: ImageView
        var last_match_time: TextView

        init {
            name = itemView.findViewById(R.id.playerSearch_name)
            player_image = itemView.findViewById(R.id.player_imageView)
            last_match_time = itemView.findViewById(R.id.last_match_time)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.players_search_item, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val players: PlayersSearch = list[position]


        holder.last_match_time.text = players.last_match_time
        holder.name.text = list[position].personaname
        Glide.with(holder.itemView).load(players.avatarfull)
            .into(holder.itemView.player_imageView)

        holder.itemView.setOnClickListener {
            fragment.showPlayerInfo(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}