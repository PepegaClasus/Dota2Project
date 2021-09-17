package tut.example.dota2Project.RemoteModel

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tut.example.dota2Project.UI.Heroes.MatchUps
import tut.example.dota2Project.UI.Heroes.Model.Heroes
import tut.example.dota2Project.UI.Leagues.Model.League
import tut.example.dota2Project.UI.Leagues.Model.LeagueTeams
import tut.example.dota2Project.UI.LiveMatches.LiveMatch
import tut.example.dota2Project.UI.Matches.RecentMatches
import tut.example.dota2Project.UI.Players.FindPlayers.Model.PlayersSearch
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayersAccount
import tut.example.dota2Project.UI.Players.ProPlayers.Model.WL
import tut.example.dota2Project.UI.ProMatches.ProMatches
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamPlayers
import tut.example.dota2Project.UI.ProTeams.Model.ProTeams
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamsId
import tut.example.dota2Project.UI.ProTeams.Model.ProTeamsMatches
import java.util.concurrent.TimeUnit

val BASE_URL = "https://api.opendota.com/api/"

interface ApiService {

    @GET("heroStats")
    suspend fun getHeroes(): MutableList<Heroes>

    @GET("leagues")
    suspend fun getLeagues(): MutableList<League>

    @GET("teams")
    suspend fun getTeams(): MutableList<ProTeams>

    @GET("heroes/{hero_id}/matchups")
    suspend fun getHeroMatchups(
        @Path("hero_id") hero_id: Int,
    ): MutableList<MatchUps>

    @GET("leagues/{league_id}/teams")
    suspend fun getLeagueMatches(
        @Path("league_id") league_id: Int,
    ): MutableList<LeagueTeams>

    @GET("proMatches")
    suspend fun getProMatches(): MutableList<ProMatches>

    @GET("live")
    suspend fun getLiveMatches(): MutableList<LiveMatch>

    @GET("teams/{team_id}/matches")
    suspend fun getTeamMatchById(
        @Path("team_id") team_id: Int,
    ): MutableList<ProTeamsMatches>

    @GET("teams/{team_id}/players")
    suspend fun getTeamPlayersById(
        @Path("team_id") team_id: Int,
    ): MutableList<ProTeamPlayers>

    @GET("teams/{team_id}")
    suspend fun getTeamById(
        @Path("team_id") team_id: Int,
    ): ProTeamsId


    @GET("heroStats")
    suspend fun getHeroStats(): Heroes

    @GET("players/{account_id}")
    suspend fun getPlayerAccount(
        @Path("account_id") account_id: Int,
    ): ProPlayersAccount

    @GET("matches/{match_id}")
    suspend fun getMatches(
        @Path("match_id") match_id: Long,
    ): tut.example.dota2Project.UI.Matches.MatchInfoModel

    @GET("players/{account_id}/wl")
    suspend fun getWL(
        @Path("account_id") account_id: Int,
    ): WL

    @GET("players/{account_id}/recentMatches")
    suspend fun getRecentMatches(
        @Path("account_id") account_id: Int,
    ): MutableList<RecentMatches>


    @GET("search?")
    suspend fun getPlayers(
        @Query("q") Search: String,
    ): MutableList<PlayersSearch>

    @GET("proPlayers")
    suspend fun getProPlayers(): MutableList<ProPlayers>

    companion object Factory {
        fun create(): ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}