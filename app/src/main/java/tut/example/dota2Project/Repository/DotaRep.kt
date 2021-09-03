package tut.example.dota2Project.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tut.example.dota2Project.LocalModel.LocalModel
import tut.example.dota2Project.RemoteModel.RemoteModel
import tut.example.dota2Project.UI.Heroes.MatchUps
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.Items.Model.Items
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Matches.MatchInfoModel
import tut.example.dota2Project.UI.Matches.RecentMatches
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayersAccount
import tut.example.dota2Project.UI.Players.ProPlayers.Model.WL
import tut.example.dota2Project.UI.ProMatches.ProMatches
import tut.example.dota2Project.UI.ProTeams.ProTeamPlayers
import tut.example.dota2Project.UI.ProTeams.ProTeamsId
import tut.example.dota2Project.UI.ProTeams.ProTeamsMatches
import javax.inject.Inject

class DotaRep @Inject constructor(val remoteModel: RemoteModel, val localModel: LocalModel) {
    suspend fun getData(): MutableList<Heroes> {
        var heroesList = localModel.getAllHeroes()
        return if (heroesList.isEmpty()) {
            heroesList = remoteModel.getRemoteHeroes()
            localModel.insertHeroes(heroesList)

            heroesList
        } else {
            heroesList
        }
    }

    suspend fun getPlayerId(account_id: Int): ProPlayersAccount? = withContext(Dispatchers.Main) {
        val playerInfo: ProPlayersAccount? = remoteModel.getPlayerInfo(account_id)
        return@withContext playerInfo
    }

    suspend fun getMatchById(match_id: Long): MatchInfoModel? = withContext(Dispatchers.Main) {
        val matchByIdModel: MatchInfoModel? = remoteModel.getMatchById(match_id)
        return@withContext matchByIdModel
    }

    suspend fun getHeroMatchup(hero_id: Int): MutableList<MatchUps> =
        withContext(Dispatchers.Main) {
            val heroMatchup = remoteModel.getHeroMatchup(hero_id)
            return@withContext heroMatchup
        }

    suspend fun getRecentMatchesById(account_id: Int): MutableList<RecentMatches> =
        withContext(Dispatchers.Main) {
            val recentMatches = remoteModel.getRecentMatchesById(account_id)
            return@withContext recentMatches
        }

    suspend fun getWLPlayerById(account_id: Int): WL = withContext(Dispatchers.Main) {
        val wlPlayerById: WL? = remoteModel.getWLPlayerById(account_id)
        return@withContext wlPlayerById!!
    }

    suspend fun getMatches(): MutableList<ProMatches> = withContext(Dispatchers.Main) {
        val proMatches = remoteModel.getProMatches()
        return@withContext proMatches
    }

    suspend fun getTeamById(team_id: Int): ProTeamsId? = withContext(Dispatchers.Main) {
        val teamsById: ProTeamsId? = remoteModel.getTeamById(team_id)
        return@withContext teamsById
    }

    suspend fun getTeamMatchesById(team_id: Int): ProTeamsMatches? = withContext(Dispatchers.Main) {
        val teamsMatchesById: ProTeamsMatches? = remoteModel.getTeamMatchesById(team_id)
        return@withContext teamsMatchesById
    }

    suspend fun getTeamPlayersById(team_id: Int): ProTeamPlayers? = withContext(Dispatchers.Main) {
        val teamPlayersById: ProTeamPlayers? = remoteModel.getTeamPlayersById(team_id)
        return@withContext teamPlayersById
    }


    suspend fun getItems(): MutableList<Items> {
        return remoteModel.getItems()
    }

    suspend fun getSecondItems(): MutableList<Items> {
        return remoteModel.getSecondItems()
    }

    suspend fun getThirdItems():MutableList<Items>{
        return remoteModel.getThirdItems()
    }

    suspend fun getFourthItems():MutableList<Items>{
        return remoteModel.getFourthItems()
    }

    suspend fun getLiveMatches():MutableList<LiveMatch>{
        var liveMatches = localModel.getAllLiveMatches()

        return if (liveMatches.isEmpty()){
            liveMatches = remoteModel.getLiveMatches()
            localModel.insertLiveMatches(liveMatches)
            liveMatches
        }else {
            liveMatches
        }
    }

    suspend fun getProPlayers():MutableList<ProPlayers> {
        var proPlayers = localModel.getAllProPlayers()

        return if (proPlayers.isEmpty()) {
            proPlayers = remoteModel.getProPlayers()
            localModel.insertProPlayers(proPlayers)
            proPlayers
        } else {
            proPlayers
        }
    }












}