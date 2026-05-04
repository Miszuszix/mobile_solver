package com.example.puzzlesolver.ui.viewmodel

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PuzzleViewModelTest {

    @Test
    fun `clicking valid adjacent tile should update state`() = runTest {
        val viewModel = PuzzleViewModel()

        viewModel.uiState.test {
            val initialState = awaitItem()
            assertEquals(0, initialState.board[8])

            viewModel.onTileClicked(8)

            val newState = awaitItem()
            
            assertEquals(7, newState.board.indexOf(0))
            assertEquals(8, newState.board.indexOf(8))
            
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `clicking non-adjacent tile should NOT update state`() = runTest {
        val viewModel = PuzzleViewModel()

        viewModel.uiState.test {
            awaitItem()
            
            viewModel.onTileClicked(1)
            
            expectNoEvents()

            cancelAndIgnoreRemainingEvents()
        }
    }
}