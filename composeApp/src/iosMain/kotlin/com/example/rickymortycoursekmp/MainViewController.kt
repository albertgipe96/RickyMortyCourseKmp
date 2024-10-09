package com.example.rickymortycoursekmp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.rickymortycoursekmp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }