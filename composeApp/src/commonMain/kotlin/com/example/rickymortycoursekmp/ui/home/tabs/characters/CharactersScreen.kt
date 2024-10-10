@file:OptIn(KoinExperimentalAPI::class)

package com.example.rickymortycoursekmp.ui.home.tabs.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun CharactersScreen() {
    val characterViewModel = koinViewModel<CharacterViewModel>()
    val state = characterViewModel.state.collectAsState()
}