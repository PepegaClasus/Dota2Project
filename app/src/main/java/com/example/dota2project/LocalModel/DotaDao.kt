package com.example.dota2project.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers


@Dao
interface DotaDao {
    @Insert
    suspend fun insertHeroes(heroes: MutableList<Heroes>)

    @Query("SELECT * FROM heroes")
    suspend fun selectAllHeroes(): MutableList<Heroes>

//    @Insert
//    suspend fun insertItems(items:MutableList<Items>)
//    @Query ("SELECT * FROM items")
//    suspend fun getAllItems():MutableList<Items>
//
//    @Insert
//    suspend fun insertSecondItems(secondItems:MutableList<Items>)
//    @Query ("SELECT * FROM items")
//    suspend fun getAllSecondItems():MutableList<Items>
//
//    @Insert
//    suspend fun insertThirdItems(thirdItems:MutableList<Items>)
//    @Query ("SELECT * FROM items")
//    suspend fun getAllThirdItems():MutableList<Items>
//
//    @Insert
//    suspend fun insertFourthItems(fourthItems:MutableList<Items>)
//    @Query ("SELECT * FROM items")
//    suspend fun getAllFourthItems():MutableList<Items>


    @Insert
    suspend fun insertProPlayers(proPlayers: MutableList<ProPlayers>)

    @Query("SELECT * FROM proPlayers")
    suspend fun getAllProPlayers(): MutableList<ProPlayers>


}