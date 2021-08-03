package com.example.dota2project.RemoteModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "heroes")
data class Heroes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val localized_name: String,
    val attack_type: String,
    val primary_attr: String,
    val hero_image: Int,
)


data class MyTeams(
    val carry:String = "",
    val carry_country:String = "",
    val carry_image:String = "",
    val carry_name:String = "",
    val carry_role:String = "",
    val carry_year:String = "",
    val description:String = "",
    val earn:String = "",
    val logo:String = "",
    val mid:String = "",
    val mid_country:String = "",
    val mid_image:String = "",
    val mid_name:String = "",
    val mid_role:String = "",
    val mid_year:String = "",
    val name:String = "",
    val offlane:String = "",
    val offlane_country:String = "",
    val offlane_image:String = "",
    val offlane_name:String = "",
    val offlane_role:String = "",
    val offlane_year:String = "",
    val rank:String = "",
    val semiSupport:String = "",
    val semiSupport_country:String = "",
    val semiSupport_image:String = "",
    val semiSupport_role:String = "",
    val semiSupport_year:String = "",
    val support:String = "",
    val support_country:String = "",
    val support_image:String = "",
    val support_name:String = "",
    val support_role:String = "",
    val support_year:String = "",
    val team_country_image:String = "",
    val trofeys:String = ""

) {
}

//@Entity(tableName = "players")
//data class Players(
//    @PrimaryKey(autoGenerate = true) val id: Int,
//    val name: String,
//    val personaname: String,
//)
@Entity (tableName = "play")
data class profile(
    @PrimaryKey(autoGenerate = true) val account_id:Int,
    val tracked_until:String,
    val solo_competitive_rank:String,
    val competitive_rank:String,
    val rank_tier:Int


)

data class MyMajors (
    val name:String = "",
    val prize:String = "",
    val winner:String = "",
    val winner_image:String = ""
)