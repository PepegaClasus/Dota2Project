package com.example.dota2project.UI.Players.FindPlayers.Model

data class PlayersSearch(
    val account_id: Int,
    val personaname: String,
    val avatarfull: String,
    val last_match_time: String,
    val similarity: Double,
)