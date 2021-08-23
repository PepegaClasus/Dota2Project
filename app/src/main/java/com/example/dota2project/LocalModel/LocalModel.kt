package com.example.dota2project.LocalModel

import android.content.Context
import androidx.room.Room
import com.example.dota2project.UI.Heroes.Model.Heroes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalModel @Inject constructor(@ApplicationContext context: Context) {
    private val dataBase:DotaDataBase = Room.databaseBuilder(
        context, DotaDataBase :: class.java, "dota_db"
    ).build()

    suspend fun insertHeroes(heroes:MutableList<Heroes>){
        dataBase.myHeroesDao().insertHeroes(heroes)
    }
    suspend fun getAllHeroes():MutableList<Heroes>{
        return dataBase.myHeroesDao().selectAllHeroes()
    }










}