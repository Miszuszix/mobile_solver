package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.AlgorithmResult
import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.Node
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.isActive

class DfsAlgorithm {
    suspend fun solve(
        initialState: PuzzleState,
        goalState: PuzzleState,
        moveOrder: List<Move>,
        maxDepth: Int = 20
    ): AlgorithmResult {

        val initialNode = Node(initialState)

        val openStates = ArrayDeque<Node>()
        val closedStates = mutableSetOf<PuzzleState>()

        var generatedCount = 0
        var visitedCount = 0

        openStates.addLast(initialNode)
        closedStates.add(initialState)
        generatedCount++

        while (openStates.isNotEmpty() && currentCoroutineContext().isActive) {
            val currentNode = openStates.removeLast()
            visitedCount++

            if (currentNode.state == goalState) {
                return AlgorithmResult(currentNode, generatedCount, visitedCount)
            }
            if (currentNode.depth >= maxDepth) continue
            for(neighbour in currentNode.expand(moveOrder).reversed()){
                if (neighbour.state !in closedStates){
                    closedStates.add(neighbour.state)
                    openStates.addLast(neighbour)
                    generatedCount++
                }
            }
        }
        return AlgorithmResult(null, generatedCount, visitedCount)
    }
}