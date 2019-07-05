package dev.mvillasenor.speedrunapiclient.stores

import dev.mvillasenor.speedrunapiclient.models.ApiResponse
import dev.mvillasenor.speedrunapiclient.models.Pagination
import dev.mvillasenor.speedrunapiclient.retrofit.GamesApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GamesStoreTest {

    private val gamesApi = mockk<GamesApi>()

    @Test
    fun performSearch() = runBlocking {
        val query = "testing my query"

        coEvery { gamesApi.search(any()) } returns ApiResponse(listOf(), Pagination(1, 1, 1, listOf()))
        GamesStore(gamesApi)
            .performSearch(query)

        coVerify { gamesApi.search(query) }
    }
}
