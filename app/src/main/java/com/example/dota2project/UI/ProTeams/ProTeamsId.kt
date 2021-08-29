package com.example.dota2project.UI.ProTeams

data class ProTeamsId(
    val team_id: Int,
    val rating: Int,
    val wins: Int,
    val losses: Int,
    val last_match_time: Int,
    val name: String,
) {
}