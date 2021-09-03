package tut.example.dota2Project.UI.ProMatchesList.ProMatches

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.ProMatches.ProMatches
import java.text.SimpleDateFormat
import java.util.*


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
        var radiant_win: TextView? = null
        var dire_win: TextView? = null

        init {
            leagueName = itemView.findViewById(R.id.league_match_name)
            radiantName = itemView.findViewById(R.id.team_radiant_name)
            direName = itemView.findViewById(R.id.dire_name)
            radiantScore = itemView.findViewById(R.id.radiant_score)
            direScore = itemView.findViewById(R.id.dire_score)
            duration = itemView.findViewById(R.id.pro_match_duration)
            startTime = itemView.findViewById(R.id.pro_match_start_time)
            radiant_win = itemView.findViewById(R.id.radiant_win)
            dire_win = itemView.findViewById(R.id.dire_win)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.pro_match_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showMatch(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val proMatches: ProMatches = list[position]

        holder.leagueName?.text = list[position].league_name
        holder.radiantName?.text = list[position].radiant_name
        holder.radiantScore?.text = list[position].radiant_score.toString()
        holder.direScore?.text = list[position].dire_score.toString()
        holder.direName?.text = list[position].dire_name
        holder.duration?.text = list[position].duration.toString()


        if (proMatches.radiant_win) {
            holder.radiantName?.setTextColor(Color.GREEN)
            holder.direName?.setTextColor(Color.RED)

        } else {
            holder.radiantName?.setTextColor(Color.RED)
            holder.direName?.setTextColor(Color.GREEN)

        }

        var time = proMatches.duration
        val minutes = time.div(60)
        time = time.rem(60)
        val seconds = time
        if (seconds >= 10) {
            val timeString = "$minutes:$seconds"
            holder.duration?.text = timeString
        } else {
            val timeString = "$minutes:0$seconds"
            holder.duration?.text = timeString
        }

        val simpleDateFormat = SimpleDateFormat("dd MM yyyy, HH:mm:ss", Locale.ENGLISH)
        val timeStart = proMatches.start_time
        val finalTime = simpleDateFormat.format(timeStart * 1000L)
        holder.startTime?.text = finalTime


    }


    override fun getItemCount(): Int {
        return list.size
    }
}