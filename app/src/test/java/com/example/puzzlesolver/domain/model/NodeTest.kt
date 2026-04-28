package com.example.puzzlesolver.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class NodeTest {

    @Test
    fun `getPath should return correct sequence of moves from root to target node`() {
        val dummyState = PuzzleState(listOf(
            listOf(1, 2, 3),
            listOf(4, 0, 6),
            listOf(7, 5, 8)
        ), 0, 2)

        val rootNode = Node(dummyState)
        val child1 = Node(dummyState, rootNode, Move.UP)
        val child2 = Node(dummyState, child1, Move.RIGHT)

        val path = child2.getPath()
        
        assertEquals(2, path.size)
        assertEquals(Move.UP, path[0])
        assertEquals(Move.RIGHT, path[1])
    }
}