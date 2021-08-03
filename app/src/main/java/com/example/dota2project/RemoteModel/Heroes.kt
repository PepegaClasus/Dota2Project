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


data class Teams(
    val name: String,
    val teamMoney: String,
    val rating: Int,
    val img_team: Int,
    val player1: Int,
    val name_player1: String,
    val age_player1: String,
    val role_player1: String,
    val earn_player1: String,

    val player2: Int,
    val name_player2: String,
    val age_player2: String,
    val role_player2: String,
    val earn_player2: String,


    val player3: Int,
    val name_player3: String,
    val age_player3: String,
    val role_player3: String,
    val earn_player3: String,


    val player4: Int,
    val name_player4: String,
    val age_player4: String,
    val role_player4: String,
    val earn_player4: String,


    val player5: Int,
    val name_player5: String,
    val age_player5: String,
    val role_player5: String,
    val earn_player5: String,


    val trofeys: String,
    val description: String,
    val img_counryTeam: Int,
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