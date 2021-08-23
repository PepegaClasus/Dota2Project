package com.example.dota2project.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Players.FindPlayers.Model.PlayersSearch
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers

@Database(entities = [Heroes::class, PlayersSearch::class, ProPlayers::class],
    version = 1)
abstract class DotaDataBase : RoomDatabase() {
    abstract fun myHeroesDao(): DotaDao
}