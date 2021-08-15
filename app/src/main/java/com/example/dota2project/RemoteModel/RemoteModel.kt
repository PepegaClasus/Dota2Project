package com.example.dota2project.RemoteModel

import android.util.Log
import javax.inject.Inject

class RemoteModel @Inject constructor() {
    val apiService = ApiService.create()
    val pandaApi = PandaScoreApi.create()


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

    suspend fun getRunningTournaments():MutableList<Tournaments>{
        return try {
            val tournaments = pandaApi.getRunningTournaments()
            tournaments
        }catch (e:Exception){
            mutableListOf()
        }
    }
    suspend fun getUpcomingTournaments():MutableList<Tournaments>{
        return try {
            val tournaments = pandaApi.getUpcomingTournaments()
            tournaments
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getPastTournaments():MutableList<Tournaments>{
        return try {
            val tournaments = pandaApi.getPastTournaments()
            tournaments
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getItems():MutableList<Items>{
        return try {
            val items = pandaApi.getItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getSecondItems():MutableList<Items>{
        return try {
            val items = pandaApi.getSecondItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getThirdItems():MutableList<Items>{
        return try {
            val items = pandaApi.getThirdItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getFourthItems():MutableList<Items>{
        return try {
            val items = pandaApi.getFourthItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }












}