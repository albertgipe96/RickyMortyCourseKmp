package com.example.rickymortycoursekmp.di

import com.example.rickymortycoursekmp.ui.home.tabs.characters.CharacterViewModel
import com.example.rickymortycoursekmp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharacterViewModel)
}