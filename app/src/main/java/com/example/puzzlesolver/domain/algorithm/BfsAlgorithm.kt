package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.AlgorithmResult
import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.Node
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.isActive

class BfsAlgorithm(
    private val moveOrder: List<Move>
): SearchAlgorithm {
    override suspend fun solve(
        initialState: PuzzleState,
        goalState: PuzzleState,
    ): AlgorithmResult {
        val initialNode = Node(initialState)

        val openStates = ArrayDeque<Node>()
        val closedStates = mutableSetOf<PuzzleState>()

        var generatedCount = 0
        var visitedCount = 0

        openStates.add(initialNode)
        closedStates.add(initialState)
        generatedCount++

        while (openStates.isNotEmpty() && currentCoroutineContext().isActive) {
            val currentNode = openStates.removeFirst()
            visitedCount++

            if (currentNode.state == goalState) {
                return AlgorithmResult(currentNode, generatedCount, visitedCount)
            }

            for (neighbour in currentNode.expand(moveOrder)){
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