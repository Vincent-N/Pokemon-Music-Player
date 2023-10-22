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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    PokemonStartScreen()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Start.name,
        modifier = Modifier.padding(24.dp)
    ) {
        composable(route = AppScreens.Start.name) {
//            quantityOptions = DataSource.quantityOptions
        }
    }
}

@Composable
fun PokemonStartScreen(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
//    var result by remember { mutableStateOf(1) };
//    val imageResource = when (result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.mipmap.pokeball_foreground),
            contentDescription = "Pokeball"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* result = (1..6).random() */ }) {
            Text(stringResource(R.string.start))
        }
    }
}

