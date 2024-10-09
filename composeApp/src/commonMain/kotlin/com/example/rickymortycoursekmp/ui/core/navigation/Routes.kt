package com.example.rickymortycoursekmp.ui.core.navigation

sealed class Routes(val route: String) {
    data object Home : Routes(route = "home")
}