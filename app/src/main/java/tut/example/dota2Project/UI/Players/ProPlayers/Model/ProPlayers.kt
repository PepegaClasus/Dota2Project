package tut.example.dota2Project.UI.Players.ProPlayers.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proPlayers")
data class ProPlayers(
    @PrimaryKey(autoGenerate = true) val account_id: Int,
    val avatarfull: String,
    val personaname: String,
    val last_match_time: String,
    var fantasy_role: Int,
    val team_name: String?,

    )