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

        val openStates = PriorityQueue<Node>(compareBy { it.cost })
        val closedStates = mutableSetOf<PuzzleState>()

        var generatedCount = 0
        var visitedCount = 0
        
        val initialCost = heuristic.calculate(initialState)
        val initialNode = Node(
            state = initialState,
            parent = null,
            move = null,
            depth = 0,
            cost = initialCost
        )

        openStates.add(initialNode)
        generatedCount++

        while (openStates.isNotEmpty() && currentCoroutineContext().isActive) {
            val currentNode = openStates.poll()
            visitedCount++

            if (currentNode != null) {
                if (currentNode.state !in closedStates){
                    if (currentNode.state == goalState){
                        return AlgorithmResult(currentNode, generatedCount, visitedCount)
                    }
                    closedStates.add(currentNode.state)
                    for (neighbour in currentNode.expand()){
                        if (neighbour.state !in closedStates){
                            val hValue = heuristic.calculate(neighbour.state)
                            val fValue = hValue + neighbour.depth
                            
                            val updatedNeighbour = neighbour.copy(cost = fValue)
                            
                            openStates.add(updatedNeighbour)
                            generatedCount++
                        }
                    }
                }
            }
        }

        return AlgorithmResult(null, generatedCount, visitedCount)
    }
}