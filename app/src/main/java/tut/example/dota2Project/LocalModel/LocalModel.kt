package tut.example.dota2Project.LocalModel

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.UI.ProTeams.Model.ProTeams
import javax.inject.Inject

class LocalModel @Inject constructor(@ApplicationContext context: Context) {
    private val dataBase: DotaDataBase = Room.databaseBuilder(
        context, DotaDataBase::class.java, "dota_db"
    ).build()

    suspend fun insertHeroes(heroes: MutableList<Heroes>) {
        dataBase.myHeroesDao().insertHeroes(heroes)
    }

    suspend fun getAllHeroes(): MutableList<Heroes> {
        return dataBase.myHeroesDao().selectAllHeroes()
    }

    suspend fun insertLiveMatches(liveMatch: MutableList<LiveMatch>) {
        dataBase.myHeroesDao().insertLiveMatches(liveMatch)
    }

    suspend fun getAllLiveMatches(): MutableList<LiveMatch> {
        return dataBase.myHeroesDao().getAllLiveMatches()
    }

    suspend fun insertProTeams(proTeams: MutableList<ProTeams>) {
        dataBase.myHeroesDao().insertTeams(proTeams)
    }

    suspend fun getAllProTeams(): MutableList<ProTeams> {
        return dataBase.myHeroesDao().getAllProTeams()
    }
//    suspend fun insertItems(items:MutableList<Items>){
//        dataBase.myHeroesDao().insertItems(items)
//    }
//    suspend fun getAllItems():MutableList<Items>{
//        return dataBase.myHeroesDao().getAllItems()
//    }
//
//    suspend fun insertSecondItems(secondItems:MutableList<Items>){
//        dataBase.myHeroesDao().insertSecondItems(secondItems)
//    }
//    suspend fun getAllSecondItems():MutableList<Items>{
//        return dataBase.myHeroesDao().getAllSecondItems()
//    }
//
//    suspend fun insertThirdItems(thirdItems:MutableList<Items>){
//        dataBase.myHeroesDao().insertThirdItems(thirdItems)
//    }
//    suspend fun getAllThirdItems():MutableList<Items>{
//        return dataBase.myHeroesDao().getAllThirdItems()
//    }
//
//    suspend fun insertFourthItems(fourthItems:MutableList<Items>){
//        dataBase.myHeroesDao().insertFourthItems(fourthItems)
//    }
//    suspend fun getAllFourthItems():MutableList<Items>{
//        return dataBase.myHeroesDao().getAllFourthItems()
//    }


    suspend fun insertProPlayers(proPlayers: MutableList<ProPlayers>) {
        dataBase.myHeroesDao().insertProPlayers(proPlayers)
    }

    suspend fun getAllProPlayers(): MutableList<ProPlayers> {
        return dataBase.myHeroesDao().getAllProPlayers()
    }












}