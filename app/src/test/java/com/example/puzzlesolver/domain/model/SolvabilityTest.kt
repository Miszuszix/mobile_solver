package com.example.puzzlesolver.domain.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SolvabilityTest {

    @Test
    fun `isSolvable should return true for solvable 3x3 board`() {
        val board = intArrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 0, 8
        )
        val state = PuzzleState(board, 3, 3, 2, 1)
        assertTrue(state.isSolvable())
    }

    @Test
    fun `isSolvable should return false for impossible 3x3 board`() {
        val board = intArrayOf(
            1, 2, 3,
            4, 5, 6,
            8, 0, 7
        )
        val state = PuzzleState(board, 3, 3, 2, 1)
        assertFalse(state.isSolvable())
    }
}