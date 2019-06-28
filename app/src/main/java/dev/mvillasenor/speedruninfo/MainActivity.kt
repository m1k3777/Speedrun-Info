package dev.mvillasenor.speedruninfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.mvillasenor.speedrunapiclient.SpeedrunApiClient
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    val client = SpeedrunApiClient.Builder(this).build()

    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val results= client.gamesStore.performSearch("The Messenger")
            Log.d("test", "The number of results is ${results.size}")
        }
    }
}
