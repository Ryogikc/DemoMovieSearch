package com.leagueofdevs.demomoviesearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leagueofdevs.demomoviesearch.ui.ButtonLayout
import com.leagueofdevs.demomoviesearch.ui.FavoriteMovieGrid
import com.leagueofdevs.demomoviesearch.ui.FavoritesViewModel
import com.leagueofdevs.demomoviesearch.ui.GalleryViewModel
import com.leagueofdevs.demomoviesearch.ui.MainLayout
import com.leagueofdevs.demomoviesearch.ui.MovieGrid
import com.leagueofdevs.demomoviesearch.ui.MovieTheme
import com.leagueofdevs.demomoviesearch.ui.NavigationItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MovieTheme {
                MovieListApp()
            }
        }
    }
}

@Composable
fun MovieListApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = MaterialTheme.colors.onSecondary,
        contentColor = Color.White
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.surface,
                unselectedContentColor = Color.White,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Favorites.route) {
            FavoriteScreen()
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    galleryViewModel: GalleryViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
) {
    val galleryUiState by galleryViewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))

        MainLayout(
            titleToSearch = galleryViewModel.titleToSearch,
            titleToSearchChanged = { galleryViewModel.updateTitleToSearch(it) }
        )
        ButtonLayout()
        Spacer(Modifier.height(16.dp))
        Snackbar()
        MovieGrid(galleryUiState.list,
            onAddFavoriteClick = {
                coroutineScope.launch {
                    favoritesViewModel.newFavoriteMovie(
                        it.imdbID, it.title, it.genre ?: "", it.plot ?: "", it.poster ?: "N/A",
                    )
                }
            })
    }
}

@Composable
fun FavoriteScreen(
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
) {
    val favoriteMovieList by favoritesViewModel.favoriteMovieList.collectAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(R.string.title_favorites),
            color = Color.Black,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        FavoriteMovieGrid(favoriteMovieList, onDeleteFavoriteClick = {
            coroutineScope.launch {
                favoritesViewModel.deleteFavoriteById(it.imdbID)
            }
        })
    }
}

@Composable
fun Snackbar(favoritesViewModel: FavoritesViewModel = hiltViewModel()) {
    val showSnackbar by favoritesViewModel.showSnackbar.collectAsState()

    if (showSnackbar) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                TextButton(onClick = {
                    favoritesViewModel.dismissSnackBar()
                }) {
                    Text(text = stringResource(id = R.string.ok))
                }
            }
        ) {
            Text(text = stringResource(R.string.snack_bar_favorite_added))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}
