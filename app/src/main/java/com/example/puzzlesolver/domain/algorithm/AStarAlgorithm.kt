package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.algorithm.heuristic.Heuristic
import com.example.puzzlesolver.domain.model.AlgorithmResult
import com.example.puzzlesolver.domain.model.Node
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.isActive
import java.util.PriorityQueue

class AStarAlgorithm(
    private val heuristic: Heuristic
) : SearchAlgorithm {

    override suspend fun solve(
        initialState: PuzzleState,
        goalState: PuzzleState,
    ): AlgorithmResult {
        val openStates = PriorityQueue<Node>()
        val visitedScores = mutableMapOf<PuzzleState, Int>()

        var generatedCount = 0
        var visitedCount = 0
        val initialNode = Node(
            state = initialState,
            depth = 0,
            cost = heuristic.calculate(initialState)
        )

        openStates.add(initialNode)
        visitedScores[initialState] = 0
        generatedCount++

        while (openStates.isNotEmpty() && currentCoroutineContext().isActive) {
            val currentNode = openStates.poll() ?: continue
            visitedCount++

            if (currentNode.state == goalState) {
                return AlgorithmResult(currentNode, generatedCount, visitedCount)
            }

            for (neighbour in currentNode.expand()) {
                val newGScore = neighbour.depth
                val existingGScore = visitedScores[neighbour.state] ?: Int.MAX_VALUE

                if (newGScore < existingGScore) {
                    visitedScores[neighbour.state] = newGScore

                    val fValue = newGScore + heuristic.calculate(neighbour.state)
                    val updatedNeighbour = neighbour.copy(cost = fValue)

                    openStates.add(updatedNeighbour)
                    generatedCount++
                }
            }
        }

        return AlgorithmResult(null, generatedCount, visitedCount)
    }
}