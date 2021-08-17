package com.example.dota2project.RemoteModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "heroes")
data class Heroes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val localized_name: String,
    val attack_type: String,
    val primary_attr: String,
    var img: String,
    val icon: String,
    val base_health: Int,
    val base_health_regen: Double,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_armor: Double,
    val base_attack_min: Int,
    val base_attack_max: Int,
    val base_str:Int,
    val base_agi: Int,
    val base_int: Int,
    val str_gain: Double,
    val agi_gain: Double,
    val int_gain: Double,
    val attack_range: Int,
    val move_speed: Double,

    val pro_pick: Int,
    @SerializedName("1_pick")
    val herald_pick: Int,

    @SerializedName("1_win")
    val herald_win: Int,

    @SerializedName("2_pick")
    val Guardian_picks: Int,

    @SerializedName("2_win")
    val Guardian_wins: Int,

    @SerializedName("3_pick")
    val Crusader_picks: Int,

    @SerializedName("3_win")
    val Crusader_wins: Int,

    @SerializedName("4_pick")
    val Archon_picks: Int,

    @SerializedName("4_win")
    val Archon_wins: Int,

    @SerializedName("5_pick")
    val Legend_picks: Int,

    @SerializedName("5_win")
    val Legend_wins: Int,

    @SerializedName("6_pick")
    val Ancient_picks: Int,

    @SerializedName("6_win")
    val Ancient_wins: Int,

    @SerializedName("7_pick")
    val Divine_picks: Int,

    @SerializedName("7_win")
    val Divine_wins: Int,

    @SerializedName("8_pick")
    val Immortal_picks: Int,

    @SerializedName("8_win")
    val Immortal_wins: Int,

    val turbo_pick:Int,
    val turbo_win:Int

    )


data class MyTeamsFireBase(
    val carry: String = "",
    val carry_country: String = "",
    val carry_image: String = "",
    val carry_name: String = "",
    val carry_role: String = "",
    val carry_year: String = "",
    val description: String = "",
    val earn: String = "",
    val logo: String = "",
    val mid: String = "",
    val mid_country: String = "",
    val mid_image: String = "",
    val mid_name: String = "",
    val mid_role: String = "",
    val mid_year: String = "",
    val name: String = "",
    val offlane: String = "",
    val offlane_country: String = "",
    val offlane_image: String = "",
    val offlane_name: String = "",
    val offlane_role: String = "",
    val offlane_year: String = "",
    val rank: String = "",
    val semiSupport: String = "",
    val semiSupport_country: String = "",
    val semiSupport_image: String = "",
    val semiSupport_role: String = "",
    val semiSupport_year: String = "",
    val support: String = "",
    val support_country: String = "",
    val support_image: String = "",
    val support_name: String = "",
    val support_role: String = "",
    val support_year: String = "",
    val team_country_image: String = "",
    val trofeys: String = "",

    )

data class PlayersSearch(
    val account_id: Int,
    val personaname: String,
    val avatarfull: String,
    val last_match_time: String,
    val similarity:Double
)

@Entity(tableName = "teams")
data class MyTeams(
    @PrimaryKey val team_id: Int,
    val rating: Int,
    val wins: Int,
    val losses: Int,
    val name: String,
    val logo_url: String,
)


data class MyMajors(
    val name: String = "",
    val prize: String = "",
    val winner: String = "",
    val winner_image: String = "",
)

data class Tournaments(
    val begin_at:String,
    val league:League,
    val prizepool:String

){





}
data class League(
    val name:String,
    val image_url:String
)


data class Items(
    val id:Int,
    val cost:Int,
    val name:String,
    val image_url: String

)

data class ProPlayers(
    val avatarfull: String,
    val personaname: String,
    val last_match_time: String,
    var fantasy_role:Int,
    val team_name:String,

    )




