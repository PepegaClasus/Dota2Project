package com.example.dota2project.RemoteModel

import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Items.Model.Items
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Tournaments.Model.Tournaments
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

    suspend fun getProPlayers():MutableList<ProPlayers>{
        return try {
            val proPlayers = apiService.getProPlayers()
            proPlayers
        }catch (e:Exception){
            mutableListOf()
        }
    }












}