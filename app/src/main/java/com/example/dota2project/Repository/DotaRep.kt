package com.example.dota2project.Repository

import com.example.dota2project.LocalModel.LocalModel
import com.example.dota2project.RemoteModel.RemoteModel
import com.example.dota2project.UI.Items.Model.Items
import com.example.dota2project.UI.Matches.MatchInfo
import com.example.dota2project.UI.Matches.RecentMatches
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayersAccount
import com.example.dota2project.UI.Players.ProPlayers.Model.WL
import com.example.dota2project.UI.ProMatches.ProMatches
import com.example.dota2project.UI.ProTeams.ProTeamPlayers
import com.example.dota2project.UI.ProTeams.ProTeamsId
import com.example.dota2project.UI.ProTeams.ProTeamsMatches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DotaRep @Inject constructor(val remoteModel: RemoteModel, val localModel: LocalModel) {
//    suspend fun getData(): MutableList<Heroes> {
//        var heroesList = localModel.getAllHeroes()
//        return if (heroesList.isEmpty()) {
//            heroesList = remoteModel.getRemoteHeroes() as MutableList<Heroes>
//            localModel.insertHeroes(heroesList)
//            Log.d("HeroesList", heroesList.toString())
//            heroesList
//        } else {
//            heroesList
//        }
//    }

    suspend fun getPlayerId(account_id: Int): ProPlayersAccount? = withContext(Dispatchers.Main) {
        val playerInfo: ProPlayersAccount? = remoteModel.getPlayerInfo(account_id)
        return@withContext playerInfo
    }

    suspend fun getMatchById(match_id: Long): MatchInfo? = withContext(Dispatchers.Main) {
        val matchById: MatchInfo? = remoteModel.getMatchById(match_id)
        return@withContext matchById
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