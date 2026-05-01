package com.example.puzzlesolver.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class PuzzleStateTest {

    private lateinit var testBoard: IntArray
    private lateinit var initialState: PuzzleState
    
    @Before
    fun setup(){
        testBoard = intArrayOf(
            1,2,3,
            4,5,6,
            7,0,8
        )
        initialState = PuzzleState(testBoard, 3, 3, 2, 1)
    }
    
    @Test
    fun `createNextState should return valid state when move is within bounds`() {
        val nextState = initialState.createNextState(Move.RIGHT)
        assertNotNull(nextState)
        
        assertEquals(2, nextState?.emptyX)
        assertEquals(2, nextState?.emptyY)
        
        assertEquals(8, nextState?.board[7])
        assertEquals(0, nextState?.board[8])
        
    }

    @Test
    fun `createNextState should return null when move is out of bounds`() {
        val nextState = initialState.createNextState(Move.DOWN)
        assertNull(nextState)
    }
}