package com.github.reyst.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.reyst.kmp.di.appModule
import com.github.reyst.kmp.ui.MainScreen
import org.koin.core.context.startKoin

fun main() = application {
    startKoin { modules(appModule) }

    Window(
        onCloseRequest = ::exitApplication,
        title = "ResearchKMP",
    ) {
        MainScreen()
    }
}