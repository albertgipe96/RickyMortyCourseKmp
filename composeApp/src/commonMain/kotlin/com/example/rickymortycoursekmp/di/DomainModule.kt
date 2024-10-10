package com.example.rickymortycoursekmp.di

import com.example.rickymortycoursekmp.domain.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacter)
}