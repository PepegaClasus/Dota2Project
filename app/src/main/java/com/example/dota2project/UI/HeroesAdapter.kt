package com.example.dota2project.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.RemoteModel.MyMajors
import com.example.dota2project.RemoteModel.Teams
import kotlinx.android.synthetic.main.major_item.view.*
import java.util.ArrayList

class HeroesAdapter(val list:MutableList<Heroes>, val fragment:HeroesList): RecyclerView.Adapter<HeroesAdapter.ViewHolder>()  {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView


        init {

            name = itemView.findViewById(R.id.hero_name)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int,) {
        holder.name.text = list[position].localized_name

//        holder.heroImage.setImageResource(list[position].hero_image)
//        holder.heroImage.setImageDrawable(ContextCompat.getDrawable(context, list.))
    }

    override fun getItemCount(): Int {
        return list.size
    }




}

class StrengthAdapter(val list:MutableList<Heroes>, val fragment:StrengthList): RecyclerView.Adapter<StrengthAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView


        init {
            name = itemView.findViewById(R.id.hero_name)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrengthAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: StrengthAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].localized_name

    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class AgilityAdapter(val list:MutableList<Heroes>, val fragment:AgilityList): RecyclerView.Adapter<AgilityAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView


        init {
            name = itemView.findViewById(R.id.hero_name)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgilityAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: AgilityAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].localized_name

    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class IntelligenceAdapter(val list:MutableList<Heroes>, val fragment:IntList): RecyclerView.Adapter<IntelligenceAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView


        init {
            name = itemView.findViewById(R.id.hero_name)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntelligenceAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: IntelligenceAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].localized_name

    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class TeamAdapter(val list:MutableList<Teams>, val fragment:TeamsList): RecyclerView.Adapter<TeamAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var team_name: TextView
        var team_rating: TextView
        var teamImage: ImageView
        var teamMoney: TextView
        var teamCountry: ImageView

        init {
            team_name = itemView.findViewById(R.id.team_name)
            team_rating = itemView.findViewById(R.id.team_rating)
            teamImage = itemView.findViewById(R.id.team_image)
            teamMoney = itemView.findViewById(R.id.team_Money)
            teamCountry = itemView.findViewById(R.id.team_Countryimage)

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
        holder.team_name.text = list[position].name
        holder.team_rating.text = list[position].rating.toString()
        holder.teamImage.setImageResource(list[position].img_team)
        holder.teamMoney.text = list[position].teamMoney
        holder.teamCountry.setImageResource(list[position].img_counryTeam)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}





class TeamChinaAdapter(val list:MutableList<Teams>, val fragment: TeamsChina): RecyclerView.Adapter<TeamChinaAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var team_name: TextView
        var team_rating: TextView
        var teamImage: ImageView
        var teamMoney: TextView
        var teamCountry: ImageView

        init {
            team_name = itemView.findViewById(R.id.team_name)
            team_rating = itemView.findViewById(R.id.team_rating)
            teamImage = itemView.findViewById(R.id.team_image)
            teamMoney = itemView.findViewById(R.id.team_Money)
            teamCountry = itemView.findViewById(R.id.team_Countryimage)

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
        holder.team_name.text = list[position].name
        holder.team_rating.text = list[position].rating.toString()
        holder.teamImage.setImageResource(list[position].img_team)
        holder.teamMoney.text = list[position].teamMoney
        holder.teamCountry.setImageResource(list[position].img_counryTeam)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class TeamCISAdapter(val list:MutableList<Teams>, val fragment: TeamsCIS): RecyclerView.Adapter<TeamCISAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var team_name: TextView
        var team_rating: TextView
        var teamImage: ImageView
        var teamMoney: TextView
        var teamCountry: ImageView

        init {
            team_name = itemView.findViewById(R.id.team_name)
            team_rating = itemView.findViewById(R.id.team_rating)
            teamImage = itemView.findViewById(R.id.team_image)
            teamMoney = itemView.findViewById(R.id.team_Money)
            teamCountry = itemView.findViewById(R.id.team_Countryimage)

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
        holder.team_name.text = list[position].name
        holder.team_rating.text = list[position].rating.toString()
        holder.teamImage.setImageResource(list[position].img_team)
        holder.teamMoney.text = list[position].teamMoney
        holder.teamCountry.setImageResource(list[position].img_counryTeam)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class TeamEuropeAdapter(val list:MutableList<Teams>, val fragment: TeamsEurope): RecyclerView.Adapter<TeamEuropeAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var team_name: TextView
        var team_rating: TextView
        var teamImage: ImageView
        var teamMoney: TextView
        var teamCountry: ImageView

        init {
            team_name = itemView.findViewById(R.id.team_name)
            team_rating = itemView.findViewById(R.id.team_rating)
            teamImage = itemView.findViewById(R.id.team_image)
            teamMoney = itemView.findViewById(R.id.team_Money)
            teamCountry = itemView.findViewById(R.id.team_Countryimage)

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
        holder.team_name.text = list[position].name
        holder.team_rating.text = list[position].rating.toString()
        holder.teamImage.setImageResource(list[position].img_team)
        holder.teamMoney.text = list[position].teamMoney
        holder.teamCountry.setImageResource(list[position].img_counryTeam)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MajorAdapter(private val list: ArrayList<MyMajors>)
    : RecyclerView.Adapter<MajorAdapter.ViewHolder>()
{


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var major_name: TextView
        var major_prize: TextView
        var winner: TextView


        init {
            major_name = itemView.findViewById(R.id.major_name)
            major_prize = itemView.findViewById(R.id.major_prize)
            winner = itemView.findViewById(R.id.major_winner)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.major_item, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: MajorAdapter.ViewHolder, position: Int) {

        val majors : MyMajors = list[position]


        holder.major_name.text = majors.name
        holder.major_prize.text = majors.prize
        holder.winner.text = majors.winner


        Glide.with(holder.itemView).load(majors.winner_image).into(holder.itemView.major_image)



    }

    override fun getItemCount(): Int {
        return list.size
    }


}
