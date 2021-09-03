package tut.example.dota2Project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tut.example.dota2Project.Repository.DotaRep
import tut.example.dota2Project.UI.Heroes.MatchUps
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.Items.Model.Items
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Matches.MatchInfoModel
import tut.example.dota2Project.UI.Matches.MatchPlayerModel
import tut.example.dota2Project.UI.Matches.RecentMatches
import tut.example.dota2Project.UI.Players.FindPlayers.Model.PlayersSearch
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayersAccount
import tut.example.dota2Project.UI.Players.ProPlayers.Model.WL
import tut.example.dota2Project.UI.ProMatches.ProMatches
import tut.example.dota2Project.UI.ProTeams.ProTeamPlayers
import tut.example.dota2Project.UI.ProTeams.ProTeamsId
import tut.example.dota2Project.UI.ProTeams.ProTeamsMatches
import tut.example.dota2Project.UI.Teams.Model.MyTeams

class DotaViewModel(val dotaRep: DotaRep) : ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)


    val heroesLive: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }


    val itemsLive: MutableLiveData<MutableList<Items>> by lazy {
        MutableLiveData<MutableList<Items>>(mutableListOf())
    }

    val proPlayersLive: MutableLiveData<MutableList<ProPlayers>> by lazy {
        MutableLiveData<MutableList<ProPlayers>>(mutableListOf())
    }
    val liveMatches: MutableLiveData<MutableList<LiveMatch>> by lazy {
        MutableLiveData<MutableList<LiveMatch>>(mutableListOf())
    }


    val proPlayersRadiantLive = MutableLiveData<MutableList<MatchPlayerModel>>(mutableListOf())

    val proPlayersDireLive = MutableLiveData<MutableList<MatchPlayerModel>>(mutableListOf())

    val proMatches = MutableLiveData<MutableList<ProMatches>>(mutableListOf())

    val heroMatchups = MutableLiveData<MutableList<ProMatches>>(mutableListOf())

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

    fun getHeroes() {
        viewModelScope.launch {

            val heroes = dotaRep.getData()
            val list = heroesLive.value
            list?.addAll(heroes)
            heroesLive.postValue(list)

        }
    }

    suspend fun getPlayerById(account_id: Int): ProPlayersAccount? {

        return dotaRep.getPlayerId(account_id)

    }


    suspend fun getMatchesById(match_id: Long): MatchInfoModel? {
        return dotaRep.getMatchById(match_id)
    }

    suspend fun getRecentMatchesById(account_id: Int): MutableList<RecentMatches> {
        return dotaRep.getRecentMatchesById(account_id)
    }

    suspend fun getHeroMatchup(hero_id: Int): MutableList<MatchUps> {
        return dotaRep.getHeroMatchup(hero_id)
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

    fun getLiveMatches() {
        viewModelScope.launch {
            val items = dotaRep.getLiveMatches()
            val list = liveMatches.value
            list?.addAll(items)
            liveMatches.postValue(list)
        }
    }


    fun getItems() {
        viewModelScope.launch {
            val items = dotaRep.getItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getSecondItems() {
        viewModelScope.launch {
            val items = dotaRep.getSecondItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getThirdItems() {
        viewModelScope.launch {
            val items = dotaRep.getThirdItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getFourthItems() {
        viewModelScope.launch {
            val items = dotaRep.getFourthItems()
            val list = itemsLive.value
            list?.addAll(items)
            itemsLive.postValue(list)
        }
    }

    fun getProPlayers() {

        viewModelScope.launch {
            val items = dotaRep.getProPlayers()
            val list = proPlayersLive.value
            list?.addAll(items)
            proPlayersLive.postValue(list)
        }


    }

}
















