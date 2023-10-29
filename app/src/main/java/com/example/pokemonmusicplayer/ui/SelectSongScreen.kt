package com.example.pokemonmusicplayer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokemonmusicplayer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSongScreen(passedInStringResource: Int,
                     onSelectButtonClicked: (Boolean) -> Unit,
                     onBackButtonClicked: () -> Unit,
                     modifier: Modifier = Modifier
                         .fillMaxSize()
                         .wrapContentSize(Alignment.Center)
) {
//    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    val options = stringArrayResource(R.array.song_names_arrays)
    var expanded by remember { mutableStateOf(false) }
    var userChoice by remember { mutableStateOf(options[0]) }
    var canContinue by remember { mutableStateOf(false) }
    Column (
        modifier = modifier
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = userChoice,
                onValueChange = { },
                label = { Text("Songs") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            if (selectionOption.equals(options[0])) {
                                canContinue = false
                            } else {
                                canContinue = true
                            }
                            userChoice = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = { onSelectButtonClicked(canContinue) }) {
            Text(stringResource(R.string.next))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = onBackButtonClicked) {
            Text(stringResource(R.string.back))
        }
    }
}