package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class BfsAlgorithmTest {

    @Test
    fun `solve should find correct path for simple solvable board`() = runBlocking {
        val goalBoard = listOf(
            listOf(1,2,3),
            listOf(4,5,6),
            listOf(7,8,0),
        )
        val goalState = PuzzleState(goalBoard, 2, 2)

        val initialBoard = listOf(
            listOf(1,2,3),
            listOf(4,5,6),
            listOf(7,0,8),
        )
        val initialState = PuzzleState(initialBoard, 2, 1)
        
        val moveOrder = listOf(Move.UP, Move.RIGHT, Move.DOWN, Move.LEFT)
        val algorithm = BfsAlgorithm()
        
        val result = algorithm.solve(initialState, goalState, moveOrder)

        assertNotNull(result.solutionNode)
        val path = result.solutionNode?.getPath()
        assertEquals(1, path?.size)
        assertEquals(Move.RIGHT, result.solutionNode?.getPath()?.first())
        assert(result.visitedStates > 0)
    }
}