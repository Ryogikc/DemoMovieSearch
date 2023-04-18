package com.leagueofdevs.demomoviesearch.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leagueofdevs.demomoviesearch.R

@Composable
fun MovieItemDetail(
    @DrawableRes drawable: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier


        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(250.dp)
            )
            Text(
                stringResource(id = title),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(
                stringResource(id = description),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }
    }
}


