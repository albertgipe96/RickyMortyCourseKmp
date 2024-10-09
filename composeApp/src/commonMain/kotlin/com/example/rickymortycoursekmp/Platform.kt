package com.example.rickymortycoursekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform