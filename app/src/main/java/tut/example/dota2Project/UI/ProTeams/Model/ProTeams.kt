package tut.example.dota2Project.UI.ProTeams.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProTeams")
data class ProTeams(
    @PrimaryKey(autoGenerate = true) val team_id: Int,
    val rating: Double,
    val wins: Int,
    val losses: Int,
    val last_match_time: Int,
    val name: String,
    val tag: String,
    val logo_url: String,
) {
}