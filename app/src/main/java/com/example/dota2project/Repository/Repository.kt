package com.example.dota2project.Repository

import android.util.Log
import com.example.dota2project.LocalModel.LocalModel
import com.example.dota2project.RemoteModel.*
import javax.inject.Inject

class Repository @Inject constructor(val remoteModel: RemoteModel, val localModel: LocalModel) {
    suspend fun getData():MutableList<Heroes>{
        var heroesList = localModel.getAllHeroes()
        return if (heroesList.isEmpty()){
            heroesList = remoteModel.getRemoteHeroes()
            localModel.insertHeroes(heroesList)
            Log.d("HeroesList", heroesList.toString())
            heroesList
        }else {
            heroesList
        }
    }

    suspend fun getTeams():MutableList<MyTeams>{
        var teamList = localModel.getAllTeams()
        return if (teamList.isEmpty()){
            teamList = remoteModel.getRemoteTeams()
            localModel.insertTeams(teamList)
            Log.d("TeamList!!!=", teamList.toString())
            teamList

        }else {
            teamList
        }
    }

    suspend fun getRunningTournaments(): MutableList<Tournaments> {
        return remoteModel.getRunningTournaments()
    }

    suspend fun getUpcomingTournaments(): MutableList<Tournaments> {
        return remoteModel.getUpcomingTournaments()
    }

    suspend fun getPastTournaments(): MutableList<Tournaments> {
        return remoteModel.getPastTournaments()
    }

    suspend fun getItems():MutableList<Items>{
        return remoteModel.getItems()
    }

    suspend fun getSecondItems():MutableList<Items>{
        return remoteModel.getSecondItems()
    }

    suspend fun getThirdItems():MutableList<Items>{
        return remoteModel.getThirdItems()
    }

    suspend fun getFourthItems():MutableList<Items>{
        return remoteModel.getFourthItems()
    }

    suspend fun getProPlayers():MutableList<ProPlayers>{
        return remoteModel.getProPlayers()
    }












}