package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leagueofdevs.demomoviesearch.R

@Composable
fun MainLayout(
    titleToSearch: String,
    titleToSearchChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Text(
            text = stringResource(R.string.title_search),
            color = Color.Black,
            style = MaterialTheme.typography.h3,
            modifier = modifier
                .padding(vertical = 8.dp)
                .align(alignment = CenterHorizontally)
        )

        OutlinedTextField(
            value = titleToSearch,
            singleLine = true,
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            onValueChange = titleToSearchChanged,
            label = {
                Text(stringResource(R.string.title_search))
            },
            textStyle = MaterialTheme.typography.body2,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayoutPreview() {
    MovieTheme {
        MainLayout(titleToSearch = "",
            titleToSearchChanged = { _ -> })
    }
}
