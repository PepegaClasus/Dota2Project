package com.example.dota2project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2project.MatchPlayerModel
import com.example.dota2project.Repository.DotaRep
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.Items.Model.Items
import com.example.dota2project.UI.Matches.MatchInfo
import com.example.dota2project.UI.Matches.RecentMatches
import com.example.dota2project.UI.Players.FindPlayers.Model.PlayersSearch
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayersAccount
import com.example.dota2project.UI.Players.ProPlayers.Model.WL
import com.example.dota2project.UI.ProMatches.ProMatches
import com.example.dota2project.UI.ProTeams.ProTeamPlayers
import com.example.dota2project.UI.ProTeams.ProTeamsId
import com.example.dota2project.UI.ProTeams.ProTeamsMatches
import com.example.dota2project.UI.Teams.Model.MyTeams
import kotlinx.coroutines.launch

class DotaViewModel(val dotaRep: DotaRep) : ViewModel() {


    val heroesLive: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }


    val itemsLive: MutableLiveData<MutableList<Items>> by lazy {
        MutableLiveData<MutableList<Items>>(mutableListOf())
    }

    val proPlayersLive: MutableLiveData<MutableList<ProPlayers>> by lazy {
        MutableLiveData<MutableList<ProPlayers>>(mutableListOf())
    }

    val proPlayersRadiantLive = MutableLiveData<MutableList<MatchPlayerModel>>(mutableListOf())

    val proPlayersDireLive = MutableLiveData<MutableList<MatchPlayerModel>>(mutableListOf())

    val proMatches = MutableLiveData<MutableList<ProMatches>>(mutableListOf())

    val teamById = MutableLiveData<MutableList<ProTeamsId>>(mutableListOf())

    val teamMatches = MutableLiveData<MutableList<ProTeamsMatches>>(mutableListOf())

    val teamPlayers = MutableLiveData<MutableList<ProTeamPlayers>>(mutableListOf())


    val heroesInfo: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }


    val playersLive: MutableLiveData<MutableList<PlayersSearch>> by lazy {
        MutableLiveData<MutableList<PlayersSearch>>(mutableListOf())
    }

    val recentMatches = MutableLiveData<MutableList<RecentMatches>>(mutableListOf())
    val matchesInfo = MutableLiveData<MutableList<MatchPlayerModel>>(mutableListOf())

    val myTeamsFireBaseLive: MutableLiveData<MutableList<MyTeams>> by lazy {
        MutableLiveData<MutableList<MyTeams>>(mutableListOf())
    }

    var hero_id = 0
    var player_id = 0
    var match_id = 6129301907
    var radiant_team_id = 0
    var dire_team_id = 6129301907

//    fun getHeroes(){
//        viewModelScope.launch {
//
//            val heroes = dotaRep.getData()
//            val list = heroesLive.value
//            list?.addAll(heroes)
//            heroesLive.postValue(list)
//
//        }
//    }

    suspend fun getPlayerById(account_id: Int): ProPlayersAccount? {

        return dotaRep.getPlayerId(account_id)

    }

    suspend fun getMatchesById(match_id: Long): MatchInfo? {
        return dotaRep.getMatchById(match_id)
    }

    suspend fun getRecentMatchesById(account_id: Int): MutableList<RecentMatches> {
        return dotaRep.getRecentMatchesById(account_id)
    }

    suspend fun getWLPlayerById(account_id: Int): WL? {
        return dotaRep.getWLPlayerById(account_id)
    }

    suspend fun getFuckingTeamById(team_id: Int): ProTeamsId? {
        return dotaRep.getTeamById(team_id)
    }

    suspend fun getTeamMatchesById(team_id: Int): ProTeamsMatches? {
        return dotaRep.getTeamMatchesById(team_id)
    }

    suspend fun getPlayersById(team_id: Int): ProTeamPlayers? {
        return dotaRep.getTeamPlayersById(team_id)
    }


    fun getProMatches() {
        viewModelScope.launch {
            val items = dotaRep.getMatches()
            val list = proMatches.value
            list?.addAll(items)
            proMatches.postValue(list)
        }
    }


    fun getItems(){
        viewModelScope.launch {
            val items = dotaRep.getItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getSecondItems(){
        viewModelScope.launch {
            val items = dotaRep.getSecondItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getThirdItems(){
        viewModelScope.launch {
            val items = dotaRep.getThirdItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getFourthItems(){
        viewModelScope.launch {
            val items = dotaRep.getFourthItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getProPlayers(){
        viewModelScope.launch {
            val proPlayers = dotaRep.getProPlayers()
            val list = proPlayersLive.value
            list?.addAll(proPlayers)
            proPlayersLive.postValue(list)
        }
    }
















}