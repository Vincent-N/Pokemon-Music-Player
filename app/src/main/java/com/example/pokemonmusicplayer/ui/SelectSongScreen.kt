package com.example.pokemonmusicplayer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pokemonmusicplayer.R

@Composable
fun SelectSongScreen(passedInStringResource: Int,
                    onBackButtonClicked: () -> Unit,
                    modifier: Modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
) {
//    val songDropDown: Spinner = findViewById(R.id)
    Column (
        modifier = modifier
    ) {
        Button (onClick = onBackButtonClicked) {
            Text(stringResource(R.string.back))
        }
    }
}