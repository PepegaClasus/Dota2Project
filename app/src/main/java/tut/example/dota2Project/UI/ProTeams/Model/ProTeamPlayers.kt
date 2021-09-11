package tut.example.dota2Project.UI.ProTeams.Model

data class ProTeamPlayers(
    val account_id: Int,
    val name: String,
    val games_played: Int,
    val wins: Int,
    val is_current_team_member: Boolean,
) {
}