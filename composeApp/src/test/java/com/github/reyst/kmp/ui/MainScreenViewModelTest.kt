package com.github.reyst.kmp.ui

import app.cash.turbine.test
import kotlin.test.Test
import com.github.reyst.kmp.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private const val TEST_STRING = "Test string"

class MainScreenViewModelTest {
    private lateinit var viewModel: MainScreenViewModel

    private val service = object : NetworkService {
        override suspend fun fetchData(): String = TEST_STRING
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = MainScreenViewModel(service)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `getUiState initial state check`() = runTest {
        assertTrue { viewModel.uiState.value.text.isBlank() }
    }

    @Test
    fun `fetchData success updates UiState`() = runTest {

        viewModel.uiState.test {
            val initialState = awaitItem()
            assertEquals("", initialState.text)

            initialState.fetchData()

            assertEquals(TEST_STRING, awaitItem().text)
        }
    }
}
