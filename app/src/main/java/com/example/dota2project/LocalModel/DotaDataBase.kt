package com.example.dota2project.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dota2project.UI.Heroes.Model.Heroes

@Database(entities = [Heroes::class], version = 1)
abstract class DotaDataBase: RoomDatabase() {
    abstract fun myHeroesDao():HeroesDao
}