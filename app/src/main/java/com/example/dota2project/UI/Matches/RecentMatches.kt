package com.example.dota2project.UI.Matches

import com.example.dota2project.UI.Heroes.Model.Heroes

data class RecentMatches(
    val assists: Int,
    val cluster: Int,
    val deaths: Int,
    val duration: Int,
    val game_mode: Int,
    val gold_per_min: Int,
    val hero_damage: Int,
    val hero_healing: Int,
    val hero_id: Int,
    val is_roaming: Boolean,
    val kills: Int,
    val lane: Int,
    val lane_role: Int,
    val last_hits: Int,
    val leaver_status: Int,
    val lobby_type: Int,
    val match_id: Long,
    val party_size: Int,
    val player_slot: Int,
    val radiant_win: Boolean,
    val skill: Int,
    val start_time: Int,
    val tower_damage: Int,
    val version: Int,
    val xp_per_min: Int,
    val heroes: Heroes,
) {
}