package tut.example.dota2Project.UI.ProTeams.Model

data class ProTeamsMatches(
    val match_id: Long,
    val duration: Int,
    val start_time: Int,
    val opposing_team_id: Int,
    val leagueid: Int,
    val league_name: String,
    val opposing_team_name: String,
    val opposing_team_logo: String,
    val radiant_win: Boolean,
) {
}