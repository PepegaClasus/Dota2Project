package com.example.dota2project.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.RemoteModel.MyTeams

@Database(entities = [Heroes ::class,  MyTeams :: class], version = 1)
abstract class DotaDataBase: RoomDatabase() {
    abstract fun myHeroesDao():HeroesDao
}