package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.leagueofdevs.demomoviesearch.R
import com.leagueofdevs.demomoviesearch.data.Search

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(
    movie: Search,
    onClick: () -> Unit,
) {
    var imageRes by remember { mutableStateOf(R.drawable.ic_favorite_unmarked) }
    var isCardSelected by remember { mutableStateOf(false) }

    Card(
        onClick = {
            isCardSelected = !isCardSelected
            onClick()
        },
        elevation = dimensionResource(id = R.dimen.card_elevation),
        shape = MaterialTheme.shapes.card,
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier
                .height(240.dp)
                .width(180.dp)
        ) {
            Image(
                painter =
                if (movie.poster == stringResource(id = R.string.noneImage)) {
                    rememberAsyncImagePainter(R.drawable.ic_broken_image)
                } else {
                    rememberAsyncImagePainter(movie.poster)
                },
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(180.dp)
                    .align(alignment = CenterHorizontally)
                    .padding(top = 6.dp)
            )
            imageRes = if (isCardSelected) {
                R.drawable.ic_favorite_marked
            } else {
                R.drawable.ic_favorite_unmarked
            }
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null, modifier = Modifier.padding(horizontal = 6.dp)
            )
            Text(
                text = movie.title,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp)
            )
        }
    }
}
