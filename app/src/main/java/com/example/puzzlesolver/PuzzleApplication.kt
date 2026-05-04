package com.example.puzzlesolver

import android.app.Application
import com.example.puzzlesolver.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PuzzleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PuzzleApplication)
            modules(appModule)
        }
    }
}