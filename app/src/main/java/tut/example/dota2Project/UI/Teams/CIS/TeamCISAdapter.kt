package tut.example.dota2Project.UI.Teams.CIS

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.teams_item.view.*
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Teams.Model.MyTeams

class TeamCISAdapter(private val list: MutableList<MyTeams>) :
    RecyclerView.Adapter<TeamCISAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var carry: TextView
        var carry_image: ImageView
        var carry_country: TextView

        var carry_name: TextView
        var carry_role: TextView
        var carry_year: TextView
        var mid: TextView
        var mid_image: ImageView
        var mid_country: TextView

        var mid_name: TextView
        var mid_role: TextView
        var mid_year: TextView
        var offlane: TextView
        var offlane_image: ImageView
        var offlane_country: TextView

        var offlane_name: TextView
        var offlane_role: TextView
        var offlane_year: TextView
        var semiSupport: TextView
        var semiSupport_country: TextView

        var semiSupport_name: TextView
        var semiSupport_image: ImageView
        var semiSupport_role: TextView
        var semiSupport_year: TextView
        var support: TextView
        var support_country: TextView


        var support_image: ImageView

        var support_name: TextView
        var support_role: TextView
        var support_year: TextView
        var rating: TextView
        var earn: TextView
        var team_image: ImageView
        var teamCountryImage: ImageView

        var layout: ConstraintLayout

        init {
            name = itemView.findViewById(R.id.team_name)
            rating = itemView.findViewById(R.id.team_rank)
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
            layout = itemView.findViewById(R.id.layout_team_info)
            carry_country = itemView.findViewById(R.id.countryInfo_player1)
            mid_country = itemView.findViewById(R.id.countryInfo_player2)
            offlane_country = itemView.findViewById(R.id.countryInfo_player3)
            semiSupport_country = itemView.findViewById(R.id.countryInfo_player4)
            support_country = itemView.findViewById(R.id.countryInfo_player5)
            carry_name = itemView.findViewById(R.id.player1Info_name)
            mid_name = itemView.findViewById(R.id.player2Info_name)
            offlane_name = itemView.findViewById(R.id.player3Info_name)
            semiSupport_name = itemView.findViewById(R.id.player4Info_name)
            support_name = itemView.findViewById(R.id.player5Info_name)


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
        holder.rating.text = list[position].rank.toString()
        holder.earn.text = list[position].earn
        holder.carry.text = list[position].carry
        holder.carry_role.text = list[position].carry_role
        holder.carry_year.text = list[position].carry_year
        holder.carry_country.text = list[position].carry_country
        holder.mid.text = list[position].mid
        holder.mid_role.text = list[position].mid_role
        holder.mid_year.text = list[position].mid_year
        holder.mid_country.text = list[position].mid_country
        holder.offlane.text = list[position].offlane
        holder.offlane_role.text = list[position].offlane_role
        holder.offlane_year.text = list[position].offlane_year
        holder.offlane_country.text = list[position].offlane_country
        holder.semiSupport.text = list[position].semiSupport
        holder.semiSupport_role.text = list[position].semiSupport_role
        holder.semiSupport_year.text = list[position].semiSupport_year
        holder.semiSupport_country.text = list[position].semiSupport_country
        holder.support.text = list[position].support
        holder.support_role.text = list[position].support_role
        holder.support_year.text = list[position].support_year
        holder.support_country.text = list[position].support_country
        holder.carry_name.text = list[position].carry_name
        holder.mid_name.text = list[position].mid_name
        holder.offlane_name.text = list[position].offlane_name
        holder.semiSupport_name.text = list[position].semiSupport_name
        holder.support_name.text = list[position].support_name


        holder.earn.text = list[position].earn
        Glide.with(holder.itemView).load(myTeams.logo).into(holder.itemView.team_image)
        Glide.with(holder.itemView).load(myTeams.team_country_image)
            .into(holder.itemView.team_Countryimage)
        Glide.with(holder.itemView).load(myTeams.carry_image)
            .into(holder.itemView.player1Info)
        Glide.with(holder.itemView).load(myTeams.mid_image)
            .into(holder.itemView.player2Info)
        Glide.with(holder.itemView).load(myTeams.offlane_image)
            .into(holder.itemView.player3Info)
        Glide.with(holder.itemView).load(myTeams.semiSupport_image)
            .into(holder.itemView.player4Info)
        Glide.with(holder.itemView).load(myTeams.support_image)
            .into(holder.itemView.player5Info)



        holder.itemView.setOnClickListener {
            if (holder.layout.visibility == View.GONE) {
                holder.layout.visibility = View.VISIBLE
            } else {
                holder.layout.visibility = View.GONE
            }
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }


}
