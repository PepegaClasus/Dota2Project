package com.example.dota2project.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.RemoteModel.MyTeams


@Dao
interface HeroesDao {
    @Insert
    suspend fun insertHeroes(heroes:MutableList<Heroes>)

    @Query("SELECT * FROM heroes")
    suspend fun selectAllHeroes():MutableList<Heroes>

    @Insert
    suspend fun insertTeams(teams:MutableList<MyTeams>)

    @Query ("SELECT * FROM teams")
    suspend fun selectAllTeams():MutableList<MyTeams>






}