package com.example.dota2project.UI.LiveMatches

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liveMatches")
data class LiveMatch (
    @PrimaryKey (autoGenerate = true) val match_id:Long,
    val game_time:Int,
    val average_mmr:Int,
    val radiant_score:Int,
    val dire_score:Int

        ){
}