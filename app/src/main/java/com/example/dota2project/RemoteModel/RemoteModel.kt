package com.example.dota2project.RemoteModel

import android.util.Log
import javax.inject.Inject

class RemoteModel @Inject constructor() {
    val apiService = ApiService.create()

    suspend fun getRemoteHeroes():MutableList<Heroes>{
        return try {
            val heroes = apiService.getHeroes()
            heroes

        }catch (e:Exception){
            mutableListOf()
        }
    }



    suspend fun getRemoteTeams():MutableList<MyTeams>{
        return try {
            val teams = apiService.getTeams()
            teams
        }catch (e:Exception){
            mutableListOf()
        }
    }








}