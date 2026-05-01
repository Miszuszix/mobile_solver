package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ManhattanHeuristicTest {
    private lateinit var heuristic: ManhattanHeuristic
    private lateinit var goalBoard: IntArray
    private lateinit var goalState: PuzzleState

    @Before
    fun setup() {
        goalBoard = intArrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
        )
        goalState = PuzzleState(goalBoard, 3, 3, 2, 2)
        heuristic = ManhattanHeuristic(goalState)
    }

    @Test
    fun `calculate should return 0 when states are identical`() {
        val manhattanResult = heuristic.calculate(goalState)
        assertEquals(0, manhattanResult)
    }

    @Test
    fun `calculate should return correct distance for misplaced tiles`() {
        val testBoard = intArrayOf(
            1, 2, 3,
            4, 0, 6,
            7, 5, 8
        )
        val testState = PuzzleState(testBoard, 3, 3, 1, 1)
        val manhattanResult = heuristic.calculate(testState)
        assertEquals(2, manhattanResult)
    }

    @Test
    fun `calculate should return correct distance for cross-board displacement`() {
        val testBoard = intArrayOf(
            0, 2, 3,
            4, 5, 6,
            7, 8, 1
        )
        val testState = PuzzleState(testBoard, 3, 3, 0, 0)
        val manhattanResult = heuristic.calculate(testState)
        assertEquals(4, manhattanResult)
    }
}