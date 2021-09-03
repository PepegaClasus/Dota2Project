package tut.example.dota2Project.RemoteModel

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import tut.example.dota2Project.UI.Items.Model.Items
import java.util.concurrent.TimeUnit

val Panda_URL = "https://api.pandascore.co/dota2/"
interface PandaScoreApi {



    @GET("items?page[size]=100&range[id]=1,100&token=VCpidzNp8MvY3wUeLxWao7poBevzDur4QVUkin6UzjDMYAE-HhU")
    suspend fun getItems():MutableList<Items>

    @GET("items?page[size]=100&range[id]=101,200&token=VCpidzNp8MvY3wUeLxWao7poBevzDur4QVUkin6UzjDMYAE-HhU")
    suspend fun getSecondItems():MutableList<Items>

    @GET("items?page[size]=100&range[id]=201,300&token=VCpidzNp8MvY3wUeLxWao7poBevzDur4QVUkin6UzjDMYAE-HhU")
    suspend fun getThirdItems():MutableList<Items>

    @GET("items?page[size]=100&range[id]=301,400&token=VCpidzNp8MvY3wUeLxWao7poBevzDur4QVUkin6UzjDMYAE-HhU")
    suspend fun getFourthItems():MutableList<Items>



    companion object Factory {
        fun create(): PandaScoreApi {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Panda_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(PandaScoreApi::class.java)

        }

    }
}