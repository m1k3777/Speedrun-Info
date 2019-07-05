package dev.mvillasenor.speedruninfo.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.mvillasenor.speedrunapiclient.models.Game
import dev.mvillasenor.speedrunapiclient.models.GameAssets
import dev.mvillasenor.speedrunapiclient.models.GameNames
import dev.mvillasenor.speedrunapiclient.stores.GamesStore
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val gamesStore = mockk<GamesStore>()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun performSearch() = runBlocking {
        val games = listOf(
            Game("id", GameNames("test", "testJ", "testT"), "test", mapOf("test" to GameAssets("uri", 1, 1))),
            Game("id", GameNames("test2", "test2J", "testT2"), "test2", mapOf("test2" to GameAssets("uri", 1, 1)))
        )
        coEvery { gamesStore.performSearch(any()) } returns games

        val searchViewModel = SearchViewModel(gamesStore)

        searchViewModel.performSearch("test")

        coVerify { gamesStore.performSearch("test") }

        assertEquals(Result.success(games), searchViewModel.games.value)
    }
}
