@file:OptIn(KoinExperimentalAPI::class)

package com.example.rickymortycoursekmp.ui.home.tabs.episodes

import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
}