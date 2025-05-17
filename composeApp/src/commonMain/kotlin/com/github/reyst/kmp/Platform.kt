package com.github.reyst.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform