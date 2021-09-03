package tut.example.dota2Project.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers


@Dao
interface DotaDao {
    @Insert
    suspend fun insertHeroes(heroes: MutableList<Heroes>)

    @Query("SELECT * FROM heroes")
    suspend fun selectAllHeroes(): MutableList<Heroes>

    @Insert
    suspend fun insertLiveMatches(liveMatches:MutableList<LiveMatch>)

    @Query("SELECT * FROM liveMatches")
    suspend fun getAllLiveMatches():MutableList<LiveMatch>

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