package com.example.puzzlesolver.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class NodeTest {

    @Test
    fun `getPath should return correct sequence of moves from root to target node`() {
        val dummyState = PuzzleState(intArrayOf(
            1,2,3,
            4,0,6,
            7,5,8
        ),
            3,
            3,
            1,
            1
            )

        val rootNode = Node(dummyState)
        val child1 = Node(dummyState, rootNode, Move.UP)
        val child2 = Node(dummyState, child1, Move.RIGHT)

        val path = child2.getPath()
        
        assertEquals(2, path.size)
        assertEquals(Move.UP, path[0])
        assertEquals(Move.RIGHT, path[1])
    }
}