package com.example.dota2project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2project.Repository.Repository
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Items.Model.Items
import com.example.dota2project.UI.Players.FindPlayers.Model.PlayersSearch
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Teams.Model.MyTeams
import com.example.dota2project.UI.Tournaments.Model.Tournaments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DotaViewModel(val repository: Repository): ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)




    val heroesLive: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }

    val runningTournamentsLive: MutableLiveData<MutableList<Tournaments>> by lazy {
        MutableLiveData<MutableList<Tournaments>>(mutableListOf())
    }
    val itemsLive:MutableLiveData<MutableList<Items>> by lazy {
        MutableLiveData<MutableList<Items>>(mutableListOf())
    }

    val proPlayersLive:MutableLiveData<MutableList<ProPlayers>> by lazy {
        MutableLiveData<MutableList<ProPlayers>>(mutableListOf())
    }

    val heroesInfo: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }


    val playersLive: MutableLiveData<MutableList<PlayersSearch>> by lazy {
        MutableLiveData<MutableList<PlayersSearch>>(mutableListOf())
    }

    val myTeamsFireBaseLive: MutableLiveData<MutableList<MyTeams>> by lazy {
        MutableLiveData<MutableList<MyTeams>>(mutableListOf())
    }









    fun getHeroes(){
        viewModelScope.launch {

            val heroes = repository.getData()
            val list = heroesLive.value
            list?.addAll(heroes)
            heroesLive.postValue(list)

        }
    }





    fun getRunningTournaments(){
        viewModelScope.launch {
            val tournaments = repository.getRunningTournaments()
            val list = runningTournamentsLive.value
            list?.addAll(tournaments)
            runningTournamentsLive.postValue(list)
        }
    }

    fun getUpcomingTournaments(){
        viewModelScope.launch {
            val tournaments = repository.getUpcomingTournaments()
            val list = runningTournamentsLive.value
            list?.addAll(tournaments)
            runningTournamentsLive.postValue(list)
        }
    }

    fun getPastTournaments(){
        viewModelScope.launch {
            val tournaments = repository.getPastTournaments()
            val list = runningTournamentsLive.value
            list?.addAll(tournaments)
            runningTournamentsLive.postValue(list)
        }
    }

    fun getItems(){
        viewModelScope.launch {
            val items = repository.getItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getSecondItems(){
        viewModelScope.launch {
            val items = repository.getSecondItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getThirdItems(){
        viewModelScope.launch {
            val items = repository.getThirdItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getFourthItems(){
        viewModelScope.launch {
            val items = repository.getFourthItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getProPlayers(){
        viewModelScope.launch {
            val proPlayers = repository.getProPlayers()
            val list = proPlayersLive.value
            list?.addAll(proPlayers)
            proPlayersLive.postValue(list)
        }
    }
















}