package com.example.dota2project.UI.ProTeams

data class ProTeamsMatches(
    val match_id: Int,
    val duration: Int,
    val start_time: Int,
    val radiant_team_id: Int,
    val radiant_name: String,
    val dire_team_id: Int,
    val dire_name: String,
    val leagueid: Int,
    val league_name: String,
    val radiant_score: Int,
    val dire_score: Int,
    val radiant_win: Boolean,
    val dire_win: Boolean,
) {
}