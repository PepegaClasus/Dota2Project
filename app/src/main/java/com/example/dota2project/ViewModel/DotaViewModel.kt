package com.example.dota2project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2project.RemoteModel.*
import com.example.dota2project.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DotaViewModel(val repository: Repository): ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)

    val heroesLive: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }

    val teamsLive = MutableLiveData<MutableList<MyTeams>>(mutableListOf())
    val playersLive: MutableLiveData<MutableList<PlayersSearch>> by lazy {
        MutableLiveData<MutableList<PlayersSearch>>(mutableListOf())}

    val myTeamsFireBaseLive: MutableLiveData<MutableList<MyTeamsFireBase>> by lazy {
        MutableLiveData<MutableList<MyTeamsFireBase>>(mutableListOf())
    }

    val majorsLive: MutableLiveData<MutableList<MyMajors>> by lazy {
        MutableLiveData<MutableList<MyMajors>>(mutableListOf())
    }

    var myTeamsFireBaseForInfo:MyTeamsFireBase? = null





    fun getHeroes(){
        viewModelScope.launch {

            val heroes = repository.getData()
            val list = heroesLive.value
            list?.addAll(heroes)
            heroesLive.postValue(list)

        }
    }

    fun getTeams(){
        viewModelScope.launch {
            val teams = repository.getTeams()
            val list = teamsLive.value
            list?.addAll(teams)
            teamsLive.postValue(list)
        }
    }








}