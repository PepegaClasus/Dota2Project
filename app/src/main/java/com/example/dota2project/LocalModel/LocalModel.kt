package com.example.dota2project.LocalModel

import android.content.Context
import androidx.room.Room
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import dagger.hilt.android.qualifiers.ApplicationContext
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