package com.example.pokemonmusicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonmusicplayer.ui.SelectSongScreen
import com.example.pokemonmusicplayer.ui.theme.PokemonMusicPlayerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonMusicPlayerTheme {
                PokemonApp()
            }
        }
    }
}

enum class AppScreens() {
    Start,
    InsertLocation
}

@Preview
@Composable
fun PokemonApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Start.name,
        modifier = Modifier.padding(24.dp)
    ) {
        composable(route = AppScreens.Start.name) {
            val context = LocalContext.current
            PokemonStartScreen(
                onStartButtonClicked = {
                    navController.navigate(AppScreens.InsertLocation.name)
                }
            )
        }

        composable(route = AppScreens.InsertLocation.name) {
            SelectSongScreen(
                passedInStringResource = R.string.back,
                onBackButtonClicked = { goBackToStart(navController) }
            )
        }
    }
}

@Composable
fun PokemonStartScreen(onStartButtonClicked: () -> Unit, modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.mipmap.pokeball_foreground),
            contentDescription = "Pokeball"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onStartButtonClicked) {
            Text(stringResource(R.string.start))
        }
    }
}

private fun goBackToStart(navController: NavHostController) {
    navController.popBackStack(AppScreens.Start.name, inclusive = false)
}
