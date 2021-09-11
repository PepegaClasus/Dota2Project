package tut.example.dota2Project.UI.ProTeams.Model

data class ProTeamsId(
    val team_id: Int,
    val rating: Double,
    val wins: Int,
    val losses: Int,
    val last_match_time: Int,
    val name: String,
    val tag: String,
    val logo_url:String
) {
}