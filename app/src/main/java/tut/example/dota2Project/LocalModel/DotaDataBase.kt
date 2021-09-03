package tut.example.dota2Project.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase

import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Players.FindPlayers.Model.PlayersSearch
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers

@Database(entities = [Heroes::class, PlayersSearch::class, ProPlayers::class, LiveMatch::class],
    version = 1)
abstract class DotaDataBase : RoomDatabase() {
    abstract fun myHeroesDao(): DotaDao
}