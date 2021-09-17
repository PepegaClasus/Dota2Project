package tut.example.dota2Project.RemoteModel

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tut.example.dota2Project.UI.Heroes.MatchUps
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.Items.Model.Items
import tut.example.dota2Project.UI.Leagues.Model.League
import tut.example.dota2Project.UI.Leagues.Model.LeagueTeams
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Matches.MatchInfoModel
import tut.example.dota2Project.UI.Matches.RecentMatches
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayersAccount
import tut.example.dota2Project.UI.Players.ProPlayers.Model.WL
import tut.example.dota2Project.UI.ProMatches.ProMatches
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamPlayers
import tut.example.dota2Project.UI.ProTeams.Model.ProTeams
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamsId
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamsMatches
import javax.inject.Inject

class RemoteModel @Inject constructor() {
    val apiService = ApiService.create()
    val pandaApi = PandaScoreApi.create()


    suspend fun getRemoteHeroes(): MutableList<Heroes> {
        return try {
            val heroes = apiService.getHeroes()
            heroes

        } catch (e: Exception) {
            mutableListOf()
        }
    }

    suspend fun getTeams(): MutableList<ProTeams> {
        return try {
            val proTeams = apiService.getTeams()
            proTeams
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    suspend fun getLeagues(): MutableList<League> {
        return try {
            val leagues = apiService.getLeagues()
            leagues
        } catch (e: java.lang.Exception) {
            mutableListOf()
        }
    }


    suspend fun getPlayerInfo(account_id: Int): ProPlayersAccount? =
        withContext(Dispatchers.Main) {
            var playerInfo: ProPlayersAccount? = null

            try {
                withContext(Dispatchers.IO) {
                    playerInfo = apiService.getPlayerAccount(account_id)

                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("playerInfo error", ex.toString())
            } catch (e: java.lang.Exception) {
                Log.d("internet", e.toString())
            }
            return@withContext playerInfo
        }


    suspend fun getMatchById(match_id: Long): MatchInfoModel? =
        withContext(Dispatchers.Main) {
            var matchByIdModel: MatchInfoModel? = null
            try {
                withContext(Dispatchers.IO) {
                    matchByIdModel = apiService.getMatches(match_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("matchByID error", ex.toString())
            } catch (e: Exception) {
                Log.d("internet", e.toString())
            }

            return@withContext matchByIdModel
        }

    suspend fun getRecentMatchesById(account_id: Int): MutableList<RecentMatches> {
        return try {
            val recentMatches = apiService.getRecentMatches(account_id)
            recentMatches
        } catch (e: Exception) {
            mutableListOf()
        }

    }

    suspend fun getHeroMatchup (hero_id:Int):MutableList<MatchUps>{
        return try {
            val heroMatchup = apiService.getHeroMatchups(hero_id)
            heroMatchup
        }catch (e:Exception){
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

    suspend fun getLiveMatches():MutableList<LiveMatch>{
        return try {
            val liveMatches = apiService.getLiveMatches()
            liveMatches
        }catch (e:Exception){
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
                Log.d("WLPlayersByID error", ex.toString())
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
                Log.d("TeamById error", ex.toString())
            } catch (e: Exception) {
                Log.d("internet", e.toString())
            }

            return@withContext teamsById
        }

    suspend fun getTeamMatchesById(team_id: Int): MutableList<ProTeamsMatches> =
        withContext(Dispatchers.Main) {
            var teamMatchesById: MutableList<ProTeamsMatches>? = null
            try {
                withContext(Dispatchers.IO) {
                    teamMatchesById = apiService.getTeamMatchById(team_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("TeamMatchesById error", ex.toString())
            } catch (e: Exception) {
                Log.d("!!!exception", e.toString())
            }
            return@withContext teamMatchesById!!
        }

    suspend fun getTeamPlayersById(team_id: Int): MutableList<ProTeamPlayers> =
        withContext(Dispatchers.Main) {
            var teamPlayersById: MutableList<ProTeamPlayers>? = null
            try {
                withContext(Dispatchers.IO) {
                    teamPlayersById = apiService.getTeamPlayersById(team_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("!!!", ex.toString())
            } catch (e: Exception) {
                Log.d("!!!", e.toString())
            }

            return@withContext teamPlayersById!!
        }

    suspend fun getLeagueTeams(league_id: Int): MutableList<LeagueTeams> =
        withContext(Dispatchers.Main) {
            var leagueTeams: MutableList<LeagueTeams>? = null

            try {
                withContext(Dispatchers.IO) {
                    leagueTeams = apiService.getLeagueMatches(league_id)
                }
            } catch (ex: retrofit2.HttpException) {
                Log.d("legueTeams error", ex.toString())
            } catch (e: java.lang.Exception) {
                Log.d("!!!", e.toString())
            }

            return@withContext leagueTeams!!
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