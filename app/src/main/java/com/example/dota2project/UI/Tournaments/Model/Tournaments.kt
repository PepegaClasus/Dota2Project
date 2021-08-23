package com.example.dota2project.UI.Tournaments.Model


data class Tournaments(
    val id: Int,
    val begin_at: String,
    val league: League,
    val prizepool: String,

    ) {


}

data class League(
    val name: String,
    val image_url: String,
)