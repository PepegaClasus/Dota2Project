package com.example.dota2project.RemoteModel
import com.example.dota2project.UI.Heroes.MatchUps
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.LiveMatches.LiveMatch
import com.example.dota2project.UI.Matches.RecentMatches
import com.example.dota2project.UI.Players.FindPlayers.Model.PlayersSearch
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayers
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayersAccount
import com.example.dota2project.UI.Players.ProPlayers.Model.WL
import com.example.dota2project.UI.ProMatches.ProMatches
import com.example.dota2project.UI.ProTeams.ProTeamPlayers
import com.example.dota2project.UI.ProTeams.ProTeamsId
import com.example.dota2project.UI.ProTeams.ProTeamsMatches
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

val BASE_URL = "https://api.opendota.com/api/"
interface ApiService {

    @GET("heroes")
    suspend fun getHeroes(): MutableList<Heroes>

    @GET("heroes/{hero_id}/matchups")
    suspend fun getHeroMatchups(
        @Path("hero_id") hero_id:Int
    ):MutableList<MatchUps>

    @GET("proMatches")
    suspend fun getProMatches(): MutableList<ProMatches>

    @GET("live")
    suspend fun getLiveMatches():MutableList<LiveMatch>

    @GET("teams/{team_id}/matches")
    suspend fun getTeamMatchById(
        @Path("team_id") team_id: Int,
    ): ProTeamsMatches

    @GET("teams/{team_id}/players")
    suspend fun getTeamPlayersById(
        @Path("team_id") team_id: Int,
    ): ProTeamPlayers

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
    ): com.example.dota2project.UI.Matches.MatchInfo

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