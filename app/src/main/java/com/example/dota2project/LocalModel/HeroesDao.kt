package com.example.dota2project.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dota2project.UI.Heroes.Model.Heroes


@Dao
interface HeroesDao {
    @Insert
    suspend fun insertHeroes(heroes:MutableList<Heroes>)

    @Query("SELECT * FROM heroes")
    suspend fun selectAllHeroes():MutableList<Heroes>








}