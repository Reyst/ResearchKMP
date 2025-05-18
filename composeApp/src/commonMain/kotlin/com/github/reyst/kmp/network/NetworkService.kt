package com.github.reyst.kmp.network

interface NetworkService {
    suspend fun fetchData(): String
}

