package com.example.rickymortycoursekmp.ui.core.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickymortycoursekmp.ui.core.navigation.Routes
import com.example.rickymortycoursekmp.ui.home.tabs.characters.CharactersScreen
import com.example.rickymortycoursekmp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun BottomNavigationWrapper(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Episodes.route
    ) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route) {
            CharactersScreen()
        }
    }
}