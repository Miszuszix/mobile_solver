package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ManhattanHeuristicTest {
    private lateinit var heuristic: ManhattanHeuristic
    private lateinit var goalState: PuzzleState

    @Before
    fun setup() {
        goalState = PuzzleState(
            board = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 0)
            ),
            2,
            2
        )
        heuristic = ManhattanHeuristic(goalState)
    }

    @Test
    fun `calculate should return 0 when states are identical`() {
        val manhattanResult = heuristic.calculate(goalState)
        assertEquals(0, manhattanResult)
    }

    @Test
    fun `calculate should return correct distance for misplaced tiles`() {
        val testState = PuzzleState(
            board = listOf(
                listOf(1, 2, 3),
                listOf(4, 0, 6),
                listOf(7, 5, 8)
            ),
            1,
            1
        )
        val manhattanResult = heuristic.calculate(testState)
        assertEquals(2, manhattanResult)
    }

    @Test
    fun `calculate should return correct distance for cross-board displacement`() {
        val testState = PuzzleState(
            board = listOf(
                listOf(0, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 1)
            ),
            0,
            0
        )
        val manhattanResult = heuristic.calculate(testState)
        assertEquals(4, manhattanResult)
    }
}