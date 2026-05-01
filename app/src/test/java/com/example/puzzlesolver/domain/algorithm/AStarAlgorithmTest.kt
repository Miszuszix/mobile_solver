package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.algorithm.heuristic.ManhattanHeuristic
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class AStarAlgorithmTest {

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
    fun `solve should return solution node when goal is reached in one move`() = runBlocking {
        val algorithm = AStarAlgorithm(ManhattanHeuristic(goalState))
        val result = algorithm.solve(initialState, goalState)
        
        assertNotNull(result.solutionNode)
        assertEquals(1, result.solutionNode?.getPath()?.size)
        assertEquals(2, result.visitedStates)
        assertEquals(4, result.generatedStates)
    }

    @Test
    fun `solve should return immediate solution when initial state is goal state`() = runBlocking {
        val algorithm = AStarAlgorithm(ManhattanHeuristic(goalState))

        val result = algorithm.solve(goalState, goalState)
        assertEquals(0, result.solutionNode?.getPath()?.size)
        assertEquals(1, result.visitedStates)
        assertEquals(1, result.generatedStates)
    }
}