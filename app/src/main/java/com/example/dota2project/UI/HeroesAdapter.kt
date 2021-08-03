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
import com.example.dota2project.RemoteModel.MyTeams
import kotlinx.android.synthetic.main.major_item.view.*
import kotlinx.android.synthetic.main.teams_item.view.*
import java.util.ArrayList

class HeroesAdapter(val list: MutableList<Heroes>, val fragment: HeroesList) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].localized_name

//        holder.heroImage.setImageResource(list[position].hero_image)
//        holder.heroImage.setImageDrawable(ContextCompat.getDrawable(context, list.))
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

class StrengthAdapter(val list: MutableList<Heroes>, val fragment: StrengthList) :
    RecyclerView.Adapter<StrengthAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

class AgilityAdapter(val list: MutableList<Heroes>, val fragment: AgilityList) :
    RecyclerView.Adapter<AgilityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

class IntelligenceAdapter(val list: MutableList<Heroes>, val fragment: IntList) :
    RecyclerView.Adapter<IntelligenceAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView


        init {
            name = itemView.findViewById(R.id.hero_name)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): IntelligenceAdapter.ViewHolder {
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






class MajorAdapter(private val list: ArrayList<MyMajors>) :
    RecyclerView.Adapter<MajorAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

        val majors: MyMajors = list[position]


        holder.major_name.text = majors.name
        holder.major_prize.text = majors.prize
        holder.winner.text = majors.winner


        Glide.with(holder.itemView).load(majors.winner_image).into(holder.itemView.major_image)


    }

    override fun getItemCount(): Int {
        return list.size
    }


}

class TeamAdapter(private val list: ArrayList<MyTeams>, val fragment:TeamsList) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var carry:TextView
        var carry_image:ImageView
//        var carry_name:TextView
        var carry_role:TextView
        var carry_year:TextView
        var mid:TextView
        var mid_image:ImageView
//        var mid_name:TextView
        var mid_role:TextView
        var mid_year:TextView
        var offlane:TextView
        var offlane_image:ImageView
//        var offlane_name:TextView
        var offlane_role:TextView
        var offlane_year:TextView
        var semiSupport:TextView
//        var semiSupport_country:TextView
        var semiSupport_image:ImageView
        var semiSupport_role:TextView
        var semiSupport_year:TextView
        var support:TextView
//        var support_country:TextView
        var support_image:ImageView
//        var support_name:TextView
        var support_role:TextView
        var support_year:TextView
        var rating: TextView
        var earn: TextView
        var team_image: ImageView
        var teamCountryImage: ImageView

        init {
            name = itemView.findViewById(R.id.team_name)
            rating = itemView.findViewById(R.id.team_rating)
            earn = itemView.findViewById(R.id.team_Money)
            team_image = itemView.findViewById(R.id.team_image)
            teamCountryImage = itemView.findViewById(R.id.team_Countryimage)
            carry_image = itemView.findViewById(R.id.player1)
            carry = itemView.findViewById(R.id.name_player1)
            carry_role = itemView.findViewById(R.id.role_player1)
            carry_year = itemView.findViewById(R.id.age_player1)
            mid = itemView.findViewById(R.id.name_player2)
            mid_image = itemView.findViewById(R.id.player2)
            mid_role = itemView.findViewById(R.id.role_player2)
            mid_year = itemView.findViewById(R.id.age_player2)
            offlane = itemView.findViewById(R.id.name_player3)
            offlane_image = itemView.findViewById(R.id.player3)
            offlane_role = itemView.findViewById(R.id.role_player3)
            offlane_year = itemView.findViewById(R.id.age_player3)
            semiSupport = itemView.findViewById(R.id.name_player4)
            semiSupport_image = itemView.findViewById(R.id.player4)
            semiSupport_role = itemView.findViewById(R.id.role_player4)
            semiSupport_year = itemView.findViewById(R.id.age_player4)
            support = itemView.findViewById(R.id.name_player5)
            support_image = itemView.findViewById(R.id.player5)
            support_role = itemView.findViewById(R.id.role_player5)
            support_year = itemView.findViewById(R.id.age_player5)
            team_image = itemView.findViewById(R.id.team_image)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.teams_item, parent, false)
        val holder = ViewHolder(itemView)

       


        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myTeams: MyTeams = list[position]
        holder.name.text = list[position].name
        holder.rating.text = list[position].rank
        holder.earn.text = list[position].earn
        holder.carry.text = list[position].carry
        holder.carry_role.text = list[position].carry_role
        holder.carry_year.text = list[position].carry_year
        holder.mid.text = list[position].mid
        holder.mid_role.text = list[position].mid_role
        holder.mid_year.text = list[position].mid_year
        holder.offlane.text = list[position].offlane
        holder.offlane_role.text = list[position].offlane_role
        holder.offlane_year.text = list[position].offlane_year
        holder.semiSupport.text = list[position].semiSupport
        holder.semiSupport_role.text = list[position].semiSupport_role
        holder.semiSupport_year.text = list[position].semiSupport_year
        holder.support.text = list[position].support
        holder.support_role.text = list[position].support_role
        holder.support_year.text = list[position].support_year

        holder.earn.text = list[position].earn
        Glide.with(holder.itemView).load(myTeams.logo).into(holder.itemView.team_image)
        Glide.with(holder.itemView).load(myTeams.team_country_image)
            .into(holder.itemView.team_Countryimage)
        Glide.with(holder.itemView).load(myTeams.carry_image).into(holder.itemView.player1)
        Glide.with(holder.itemView).load(myTeams.mid_image).into(holder.itemView.player2)
        Glide.with(holder.itemView).load(myTeams.offlane_image).into(holder.itemView.player3)
        Glide.with(holder.itemView).load(myTeams.semiSupport_image).into(holder.itemView.player4)
        Glide.with(holder.itemView).load(myTeams.support_image).into(holder.itemView.player5)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

