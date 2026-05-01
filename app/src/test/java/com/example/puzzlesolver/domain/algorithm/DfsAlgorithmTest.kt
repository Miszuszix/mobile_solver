package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class DfsAlgorithmTest {

    private lateinit var testBoard: IntArray
    private lateinit var goalBoard: IntArray
    private lateinit var initialState: PuzzleState
    private lateinit var goalState: PuzzleState

    @Before
    fun setup(){
        testBoard = intArrayOf(
            1,2,3,
            4,5,6,
            7,0,8
        )
        goalBoard = intArrayOf(
            1,2,3,
            4,5,6,
            7,8,0
        )
        initialState = PuzzleState(testBoard, 3, 3, 2, 1)
        goalState = PuzzleState(goalBoard, 3, 3, 2, 2)
    }
    
    @Test
    fun `solve should find correct path when solution is within maxDepth`() = runBlocking {
        val moveOrder = listOf(Move.UP, Move.RIGHT, Move.DOWN, Move.LEFT)
        val algorithm = DfsAlgorithm(moveOrder, 5)
        val result = algorithm.solve(initialState, goalState)
        
        assertNotNull(result.solutionNode)
        assertEquals(Move.RIGHT, result.solutionNode?.getPath()?.first())
    }

    @Test
    fun `solve should return null when solution is deeper than maxDepth`() = runBlocking {

        val moveOrder = listOf(Move.UP, Move.RIGHT, Move.DOWN, Move.LEFT)
        val algorithm = DfsAlgorithm(moveOrder, 0)
        val result = algorithm.solve(initialState, goalState)
        
        assertNull(result.solutionNode)
    }
}