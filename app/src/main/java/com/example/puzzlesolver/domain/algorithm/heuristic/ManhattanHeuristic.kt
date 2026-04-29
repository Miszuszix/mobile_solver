package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import kotlin.math.abs

class ManhattanHeuristic(private val goalState: PuzzleState) : Heuristic {
    private val height = goalState.board.size
    private val width = goalState.board[0].size
    
    private val goalPositions: Map<Int, Pair<Int, Int>> = buildMap {
        for (y in 0 until height) {
            for (x in 0 until width) {
                val tile = goalState.board[y][x]
                if (tile != 0){
                    put(tile, Pair(y, x))
                }
            }
        }
    }

    override fun calculate(state: PuzzleState): Int {
        var totalDistance = 0

        for (y in 0 until height) {
            for (x in 0 until width) {
                val currentTileValue = state.board[y][x]

                if (currentTileValue != 0 && currentTileValue != goalState.board[y][x]) {
                    val (goalY, goalX) = goalPositions[currentTileValue]!!
                    totalDistance += abs(goalY - y) + abs(goalX - x)
                }
            }
        }
        return totalDistance
    }
}