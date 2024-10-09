package com.example.rickymortycoursekmp.ui.core.navigation

sealed class Routes(val route: String) {
    data object Home : Routes(route = "home")

    // Bottom Navigation
    data object Episodes : Routes(route = "episodes")
    data object Characters : Routes(route = "characters")
}