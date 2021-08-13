package com.example.dota2project.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.*
import kotlinx.android.synthetic.main.heroes_item.view.*
import kotlinx.android.synthetic.main.major_item.view.*
import kotlinx.android.synthetic.main.players_search_item.view.*
import kotlinx.android.synthetic.main.teams_info_item.view.*
import kotlinx.android.synthetic.main.teams_item.view.*
import java.util.ArrayList

class HeroesAdapter(val list: MutableList<Heroes>, val fragment: HeroesList) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var img: ImageView
        var base_health: TextView
        var base_mana: TextView
        var base_armor: TextView
        var base_str: TextView
        var base_agi: TextView
        var base_int: TextView
        var attack_range: TextView
        var base_health_regen: TextView
        var base_mana_regen: TextView
        var str_gain: TextView
        var agi_gain: TextView
        var int_gain: TextView
        var layout: ConstraintLayout
        var move_speed: TextView


        init {
            base_health = itemView.findViewById(R.id.base_health)
            base_mana = itemView.findViewById(R.id.base_mana)
            base_armor = itemView.findViewById(R.id.base_armor)
            base_str = itemView.findViewById(R.id.base_str)
            base_agi = itemView.findViewById(R.id.base_agi)
            base_int = itemView.findViewById(R.id.base_int)
            attack_range = itemView.findViewById(R.id.attack_range)
            base_health_regen = itemView.findViewById(R.id.base_health_regen)
            base_mana_regen = itemView.findViewById(R.id.base_mana_regen)
            str_gain = itemView.findViewById(R.id.str_gain)
            agi_gain = itemView.findViewById(R.id.agi_gain)
            int_gain = itemView.findViewById(R.id.int_gain)
            move_speed = itemView.findViewById(R.id.move_speed)
            name = itemView.findViewById(R.id.hero_name)
            img = itemView.findViewById(R.id.hero_image)
            layout = itemView.findViewById(R.id.layout_hero_info)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)


holder.itemView.setOnClickListener {
    fragment.nextFragment(holder.layoutPosition)
}







        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val heroes: Heroes = list[position]
        holder.name.text = list[position].localized_name
        holder.base_health.text = list[position].base_health.toString()
        holder.base_mana.text = list[position].base_mana.toString()
        holder.base_armor.text = list[position].base_armor.toString()
        holder.base_str.text = list[position].base_str.toString()
        holder.base_agi.text = list[position].base_agi.toString()
        holder.base_int.text = list[position].base_int.toString()
        holder.attack_range.text = list[position].attack_range.toString()
        holder.base_health_regen.text = list[position].base_health_regen.toString()
        holder.base_mana_regen.text = list[position].base_mana_regen.toString()
        holder.str_gain.text = list[position].str_gain.toString()
        holder.agi_gain.text = list[position].agi_gain.toString()
        holder.int_gain.text = list[position].int_gain.toString()
        holder.move_speed.text = list[position].move_speed.toString()
        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)




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
        val heroes: Heroes = list[position]
        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)

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
        val heroes: Heroes = list[position]
        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)

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
        val heroes: Heroes = list[position]
        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)

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

class TeamAdapter(private val list: MutableList<MyTeamsFireBase>) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var rating: TextView
        var logo: ImageView
        var team_money: TextView


        init {
            name = itemView.findViewById(R.id.team_name)
            rating = itemView.findViewById(R.id.team_rating)
            team_money = itemView.findViewById(R.id.team_Money)
            logo = itemView.findViewById(R.id.team_image)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.teams_item, parent, false)
        val holder = ViewHolder(itemView)




        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myTeams: MyTeamsFireBase = list[position]
        holder.name.text = list[position].name
        holder.rating.text = list[position].rank.toString()

        holder.itemView.setOnClickListener {
            if (holder.team_money.visibility == View.INVISIBLE)
                holder.team_money.visibility = View.VISIBLE

        }



        Glide.with(holder.itemView).load(myTeams.logo).into(holder.itemView.team_image)


    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class TeamAdapterInfo(private val list: MutableList<MyTeamsFireBase>, val fragment: TeamsInfo) :
    RecyclerView.Adapter<TeamAdapterInfo.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var carry: TextView
        var carry_image: ImageView

        //        var carry_name:TextView
        var carry_role: TextView
        var carry_year: TextView
        var mid: TextView
        var mid_image: ImageView

        //        var mid_name:TextView
        var mid_role: TextView
        var mid_year: TextView
        var offlane: TextView
        var offlane_image: ImageView

        //        var offlane_name:TextView
        var offlane_role: TextView
        var offlane_year: TextView
        var semiSupport: TextView

        //        var semiSupport_country:TextView
        var semiSupport_image: ImageView
        var semiSupport_role: TextView
        var semiSupport_year: TextView
        var support: TextView

        //        var support_country:TextView
        var support_image: ImageView

        //        var support_name:TextView
        var support_role: TextView
        var support_year: TextView
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
            carry_image = itemView.findViewById(R.id.player1Info)
            carry = itemView.findViewById(R.id.nameInfo_player1)
            carry_role = itemView.findViewById(R.id.roleInfo_player1)
            carry_year = itemView.findViewById(R.id.ageInfo_player1)
            mid = itemView.findViewById(R.id.nameInfo_player2)
            mid_image = itemView.findViewById(R.id.player2Info)
            mid_role = itemView.findViewById(R.id.roleInfo_player2)
            mid_year = itemView.findViewById(R.id.ageInfo_player2)
            offlane = itemView.findViewById(R.id.nameInfo_player3)
            offlane_image = itemView.findViewById(R.id.player3Info)
            offlane_role = itemView.findViewById(R.id.roleInfo_player3)
            offlane_year = itemView.findViewById(R.id.ageInfo_player3)
            semiSupport = itemView.findViewById(R.id.nameInfo_player4)
            semiSupport_image = itemView.findViewById(R.id.player4Info)
            semiSupport_role = itemView.findViewById(R.id.roleInfo_player4)
            semiSupport_year = itemView.findViewById(R.id.ageInfo_player4)
            support = itemView.findViewById(R.id.nameInfo_player5)
            support_image = itemView.findViewById(R.id.player5Info)
            support_role = itemView.findViewById(R.id.roleInfo_player5)
            support_year = itemView.findViewById(R.id.ageInfo_player5)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.teams_info_item, parent, false)
        val holder = ViewHolder(itemView)




        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myTeamsFireBase: MyTeamsFireBase = list[position]
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
        Glide.with(holder.itemView).load(myTeamsFireBase.logo).into(holder.itemView.team_image)
        Glide.with(holder.itemView).load(myTeamsFireBase.team_country_image)
            .into(holder.itemView.team_Countryimage)
        Glide.with(holder.itemView).load(myTeamsFireBase.carry_image)
            .into(holder.itemView.player1Info)
        Glide.with(holder.itemView).load(myTeamsFireBase.mid_image)
            .into(holder.itemView.player2Info)
        Glide.with(holder.itemView).load(myTeamsFireBase.offlane_image)
            .into(holder.itemView.player3Info)
        Glide.with(holder.itemView).load(myTeamsFireBase.semiSupport_image)
            .into(holder.itemView.player4Info)
        Glide.with(holder.itemView).load(myTeamsFireBase.support_image)
            .into(holder.itemView.player5Info)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class PlayersInfoAdapter(val list: MutableList<PlayersSearch>, val fragment: FindPlayersFragment) :
    RecyclerView.Adapter<PlayersInfoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var player_image: ImageView

        init {
            name = itemView.findViewById(R.id.playerSearch_name)
            player_image = itemView.findViewById(R.id.player_imageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.players_search_item, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playersSearch: PlayersSearch = list[position]
        holder.name.text = list[position].personaname
        Glide.with(holder.itemView).load(playersSearch.avatarfull)
            .into(holder.itemView.player_imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

