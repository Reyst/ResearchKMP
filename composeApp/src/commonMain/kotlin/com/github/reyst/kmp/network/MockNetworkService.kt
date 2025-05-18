package com.github.reyst.kmp.network

import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class MockNetworkService : NetworkService {
    @OptIn(ExperimentalTime::class)
    override suspend fun fetchData(): String = "Mock data from KMP! (${Clock.System.now()})"
}