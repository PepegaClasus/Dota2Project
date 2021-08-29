package com.example.dota2project.UI.Players.ProPlayers.Model

data class ProPlayersAccount(
    val competitive_rank: Any,
    val leaderboard_rank: Any,
    val mmr_estimate: MmrEstimate,
    val profile: Profile,
    val rank_tier: Any,
    val solo_competitive_rank: Any,
    val tracked_until: String,
) {
}

data class Profile(
    val account_id: Int,
    val avatar: String,
    val avatarfull: String,
    val avatarmedium: String,
    val cheese: Int,
    val is_contributor: Boolean,
    val last_login: String,
    val loccountrycode: String,
    val name: Any,
    val personaname: String,
    val plus: Boolean,
    val profileurl: String,
    val steamid: String,
) {

}

data class MmrEstimate(
    val estimate: Int,
)

data class WL(
    val win: Int,
    val lose: Int,
)