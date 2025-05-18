package com.github.reyst.kmp.di

import com.github.reyst.kmp.network.MockNetworkService
import com.github.reyst.kmp.network.NetworkService
import com.github.reyst.kmp.ui.MainScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<NetworkService> { MockNetworkService() }

    viewModelOf(::MainScreenViewModel)
}