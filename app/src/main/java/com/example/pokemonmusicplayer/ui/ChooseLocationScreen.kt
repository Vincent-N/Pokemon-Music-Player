package com.example.pokemonmusicplayer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ChooseLocationScreen(
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {
    Column (
        modifier = modifier
    ) {
//        Text("meme")
//        Button (onClick = onBackButtonClicked) {
//            Text(stringResource(R.string.back))
//        }
        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }
        val latLngList = remember {
            mutableStateListOf<LatLng>()
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapClick = { position -> latLngList.add(position) }
        ) {

            println(latLngList)
            latLngList.forEach {position ->
                createMarker(position = position, latLngList = latLngList)
            }

            latLngList.drawRegion()
//            Marker(
//                state = MarkerState(position = singapore),
//                title = "Singapore",
//                snippet = "Marker in Singapore",
//                onClick = {
//                    it.remove()
//                    false
//                }
//            )
        }
    }
}

@Composable
private fun SnapshotStateList<LatLng>.drawRegion() {
    if (this.size >= 3) {
        print("""printing here ${this.size}""")
        Polygon(
            fillColor = Color(0x7F00FF00),
            points = this.toList()) // for some reason, doesn't work without the toList()
    }
}
@Composable
private fun createMarker(position: LatLng, latLngList: SnapshotStateList<LatLng>) {
    Marker(
        state = MarkerState(position = position),
        title = "Marker", // maybe have marker counter
        snippet = "Tbh not sure what this is",
        onClick = {
            latLngList.remove(it.position)
            false
        }
    )

//    println(latLngList.size)
}