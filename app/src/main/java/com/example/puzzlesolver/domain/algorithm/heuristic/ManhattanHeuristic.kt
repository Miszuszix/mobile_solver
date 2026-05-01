package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState
import kotlin.math.abs

class ManhattanHeuristic(private val goalState: PuzzleState) : Heuristic {
    private val height = goalState.height
    private val width = goalState.width
    private val goalYPositions = IntArray(width * height)
    private val goalXPositions = IntArray(width * height)
    
    init{
        for (y in 0 until height) {
            for (x in 0 until width) {
                val tile = goalState.board[y * width + x]
                if (tile != 0){
                    goalYPositions[tile] = y
                    goalXPositions[tile] = x
                }
            }
        }
    }

    override fun calculate(state: PuzzleState): Int {
        var totalDistance = 0
        var goalY: Int
        var goalX: Int
        
        for (y in 0 until height) {
            for (x in 0 until width) {
                val currentTileValue = state.board[y * width + x]

                if (currentTileValue != 0) {
                    goalY = goalYPositions[currentTileValue]
                    goalX = goalXPositions[currentTileValue]
                    totalDistance += abs(goalY - y) + abs(goalX - x)
                }
            }
        }
        return totalDistance
    }
}