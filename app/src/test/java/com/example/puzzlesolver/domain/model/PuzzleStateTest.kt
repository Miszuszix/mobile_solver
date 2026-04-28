package com.example.puzzlesolver.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Test

class PuzzleStateTest {

    @Test
    fun `createNextState should return valid state when move is within bounds`() {
        val testBoard = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 0, 8)
        )

        val initialState = PuzzleState(testBoard, 2, 1)

        val nextState = initialState.createNextState(Move.RIGHT)
        assertNotNull(nextState)
        
        assertEquals(2, nextState?.emptyX)
        assertEquals(2, nextState?.emptyY)
        
        assertEquals(8, nextState?.board[2][1])
        assertEquals(0, nextState?.board[2][2])
        
    }

    @Test
    fun `createNextState should return null when move is out of bounds`() {
        val testBoard = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 0, 8)
        )

        val initialState = PuzzleState(testBoard, 2, 1)

        val nextState = initialState.createNextState(Move.DOWN)

        assertNull(nextState)
    }
}