package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class HammingHeuristicTest {
    private lateinit var heuristic: HammingHeuristic
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
        heuristic = HammingHeuristic(goalState)
    }

    @Test
    fun `calculate should return 0 when states are identical`() {
        val hammingResult = heuristic.calculate(goalState)
        assertEquals(0, hammingResult)
    }

    @Test
    fun `calculate should return correct number of misplaced tiles`() {
        val testBoard = intArrayOf(
            1, 2, 3,
            4, 0, 6,
            7, 5, 8
        )
        val testState = PuzzleState(testBoard, 3, 3, 1, 1)
        val hammingResult = heuristic.calculate(testState)
        assertEquals(2, hammingResult)
    }
}