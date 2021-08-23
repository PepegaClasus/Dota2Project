package com.example.dota2project.Repository

import android.util.Log
import com.example.dota2project.LocalModel.LocalModel
import com.example.dota2project.RemoteModel.RemoteModel
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Items.Model.Items
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Tournaments.Model.Tournaments
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