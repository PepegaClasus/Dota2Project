package com.example.dota2project.UI.ProTeams

data class ProTeamPlayers(
    val account_id: String,
    val name: String,
    val games_played: Int,
    val wins: Int,
    val is_current_team_member: Boolean,
) {
}