package dev.mvillasenor.speedrunapiclient.retrofit

import dev.mvillasenor.speedrunapiclient.models.ApiResponse
import dev.mvillasenor.speedrunapiclient.models.Game
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {

    @GET("games")
    suspend fun search(@Query("name") name: String): ApiResponse<Game>
}
