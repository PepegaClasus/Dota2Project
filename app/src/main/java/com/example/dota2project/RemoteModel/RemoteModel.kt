package com.example.dota2project.RemoteModel

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






}