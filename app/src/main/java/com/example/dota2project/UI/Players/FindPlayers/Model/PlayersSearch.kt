package com.example.dota2project.UI.Players.FindPlayers.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playersSearch")
data class PlayersSearch(
    @PrimaryKey(autoGenerate = true) val account_id: Int,
    val personaname: String,
    val avatarfull: String,
    val last_match_time: String,
    val similarity: Double,
)