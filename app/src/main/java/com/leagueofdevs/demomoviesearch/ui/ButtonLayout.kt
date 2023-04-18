package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leagueofdevs.demomoviesearch.R

@Composable
fun ButtonLayout(
    modifier: Modifier = Modifier,
    galleryViewModel: GalleryViewModel = hiltViewModel()
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 16.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        //Button Movies
        OutlinedButton(
            onClick = { galleryViewModel.searchByMovie() },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(stringResource(R.string.search_movie))
        }
        //Button Series
        OutlinedButton(
            onClick = { galleryViewModel.searchBySeries() },
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 8.dp),
        ) {
            Text(stringResource(R.string.search_series))
        }
    }
}
