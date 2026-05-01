package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState

class HammingHeuristic(private val goalState: PuzzleState) : Heuristic {
    override fun calculate(state: PuzzleState): Int {
        var misplacedCount = 0

        val height = state.height
        val width = state.width

        for (y in 0 until height) {
            for (x in 0 until width) {
                val currentTile = state.board[y * width + x]
                if (currentTile != 0 && currentTile != goalState.board[y * width + x]){
                        misplacedCount++
                }
            }
        }
        return misplacedCount
    }
}