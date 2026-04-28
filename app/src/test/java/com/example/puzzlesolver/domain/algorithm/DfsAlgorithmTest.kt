package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class DfsAlgorithmTest {

    @Test
    fun `solve should find correct path when solution is within maxDepth`() = runBlocking {
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
        val algorithm = DfsAlgorithm()
        val result = algorithm.solve(initialState, goalState, moveOrder, 5)
        
        assertNotNull(result.solutionNode)
        assertEquals(Move.RIGHT, result.solutionNode?.getPath()?.first())
    }

    @Test
    fun `solve should return null when solution is deeper than maxDepth`() = runBlocking {
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
        val algorithm = DfsAlgorithm()
        val result = algorithm.solve(initialState, goalState, moveOrder, 0)
        
        assertNull(result.solutionNode)
    }
}