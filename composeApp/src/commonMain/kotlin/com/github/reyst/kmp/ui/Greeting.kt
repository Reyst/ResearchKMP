package com.github.reyst.kmp.ui

import com.github.reyst.kmp.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}