package com.example.dota2project.RemoteModel


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

val BASE_URL = "https://api.opendota.com/api/"

interface ApiService    {

    @GET ("heroes")
    suspend fun getHeroes():MutableList<Heroes>

    @GET ("teams")
    suspend fun getTeams():MutableList<MyTeams>

    @GET ("search?")
     suspend fun getPlayers(
        @Query ("q")Search:String
    ): MutableList<PlayersSearch>












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