package com.example.puzzlesolver.di

import org.koin.core.module.dsl.viewModelOf
import com.example.puzzlesolver.ui.viewmodel.PuzzleViewModel
import org.koin.dsl.module

val appModule = module {
        viewModelOf(::PuzzleViewModel)
}