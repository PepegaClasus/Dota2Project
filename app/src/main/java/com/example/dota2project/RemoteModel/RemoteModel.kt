package com.example.dota2project.RemoteModel

import android.util.Log
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

class RemoteModel @Inject constructor() {
    val apiService = ApiService.create()
    val pandaApi = PandaScoreApi.create()


//    suspend fun getRemoteHeroes(): List<Heroes> {
//        return try {
//            val heroes = apiService.getHeroes()
//            listOf(heroes)
//
//        }catch (e:Exception){
//            listOf()
//        }
//    }


    suspend fun getPlayerInfo(account_id: Int): ProPlayersAccount? =
        withContext(Dispatchers.Main) {
            var playerInfo: ProPlayersAccount? = null

            try {
                withContext(Dispatchers.IO) {
                    playerInfo = apiService.getPlayerAccount(account_id)

                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("nickname error", ex.toString())
            } catch (e: java.lang.Exception) {
                Log.d("internet", e.toString())
            }
            return@withContext playerInfo
        }

    suspend fun getMatchById(match_id: Long): MatchInfo? =
        withContext(Dispatchers.Main) {
            var matchById: MatchInfo? = null
            try {
                withContext(Dispatchers.IO) {
                    matchById = apiService.getMatches(match_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("nickname error", ex.toString())
            } catch (e: Exception) {
                Log.d("internet", e.toString())
            }

            return@withContext matchById
        }

    suspend fun getRecentMatchesById(account_id: Int): MutableList<RecentMatches> {
        return try {
            val recentMatches = apiService.getRecentMatches(account_id)
            recentMatches
        } catch (e: Exception) {
            mutableListOf()
        }

    }

    suspend fun getProMatches(): MutableList<ProMatches> {
        return try {
            val proMatches = apiService.getProMatches()
            proMatches
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    suspend fun getWLPlayerById(account_id: Int): WL? =
        withContext(Dispatchers.Main) {
            var wlPlayerByID: WL? = null
            try {
                withContext(Dispatchers.IO) {
                    wlPlayerByID = apiService.getWL(account_id)
                }

            } catch (ex: retrofit2.HttpException) {
                Log.d("nickname error", ex.toString())
            } catch (e: Exception) {
                Log.d("internet", e.toString())
            }

            return@withContext wlPlayerByID
        }

    suspend fun getTeamById(team_id: Int): ProTeamsId? =
        withContext(Dispatchers.Main) {
            var teamsById: ProTeamsId? = null
            try {
                withContext(Dispatchers.IO) {
                    teamsById = apiService.getTeamById(team_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("nickname error", ex.toString())
            } catch (e: Exception) {
                Log.d("internet", e.toString())
            }

            return@withContext teamsById
        }

    suspend fun getTeamMatchesById(team_id: Int): ProTeamsMatches? =
        withContext(Dispatchers.Main) {
            var teamMatchesById: ProTeamsMatches? = null
            try {
                withContext(Dispatchers.IO) {
                    teamMatchesById = apiService.getTeamMatchById(team_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("!!!", ex.toString())
            } catch (e: Exception) {
                Log.d("!!!exception", e.toString())
            }
            return@withContext teamMatchesById
        }

    suspend fun getTeamPlayersById(team_id: Int): ProTeamPlayers? =
        withContext(Dispatchers.Main) {
            var teamPlayersById: ProTeamPlayers? = null
            try {
                withContext(Dispatchers.IO) {
                    teamPlayersById = apiService.getTeamPlayersById(team_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("!!!", ex.toString())
            } catch (e: Exception) {
                Log.d("!!!", e.toString())
            }

            return@withContext teamPlayersById
        }


    suspend fun getItems(): MutableList<Items> {
        return try {
            val items = pandaApi.getItems()
            items
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    suspend fun getSecondItems():MutableList<Items>{
        return try {
            val items = pandaApi.getSecondItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getThirdItems():MutableList<Items>{
        return try {
            val items = pandaApi.getThirdItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getFourthItems():MutableList<Items>{
        return try {
            val items = pandaApi.getFourthItems()
            items
        }catch (e:Exception){
            mutableListOf()
        }
    }

    suspend fun getProPlayers():MutableList<ProPlayers>{
        return try {
            val proPlayers = apiService.getProPlayers()
            proPlayers
        }catch (e:Exception){
            mutableListOf()
        }
    }












}