package com.example.dota2project.Repository

import com.example.dota2project.LocalModel.LocalModel
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.RemoteModel.RemoteModel
import javax.inject.Inject

class Repository @Inject constructor(val remoteModel: RemoteModel, val localModel: LocalModel) {
    suspend fun getData():MutableList<Heroes>{
        var heroesList = localModel.getAllHeroes()
        return if (heroesList.isEmpty()){
            heroesList = remoteModel.getRemoteHeroes()
            localModel.insertHeroes(heroesList)
            heroesList
        }else {
            heroesList
        }
    }






}