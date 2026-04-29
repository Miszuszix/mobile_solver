package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class HammingHeuristicTest {
    private lateinit var heuristic: HammingHeuristic
    private lateinit var goalState: PuzzleState
    
    @Before
    fun setUp() {
        heuristic = HammingHeuristic()
        goalState = PuzzleState(
            listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 0)
            ),
            2,
            2
        )
    }

    @Test
    fun `calculate should return 0 when states are identical`() {
        val hammingResult = heuristic.calculate(goalState, goalState)
        assertEquals(0, hammingResult)
    }

    @Test
    fun `calculate should return correct number of misplaced tiles`() {
        val testState = PuzzleState(
            listOf(
                listOf(1,2,3),
                listOf(4,0,6),
                listOf(7,5,8),
            ),
            1,
            1
        )
        val hammingResult = heuristic.calculate(testState, goalState)
        assertEquals(2, hammingResult)
    }
}