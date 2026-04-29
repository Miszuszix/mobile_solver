package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState

class HammingHeuristic : Heuristic {
    override fun calculate(state: PuzzleState, goalState: PuzzleState): Int {
        var misplacedCount = 0

        val height = state.board.size
        val width = state.board[0].size

        for (y in 0 until height) {
            for (x in 0 until width) {
                val currentTile = state.board[y][x]
                if (currentTile != 0 && currentTile != goalState.board[y][x]){
                        misplacedCount++
                }
            }
        }
        return misplacedCount
    }
}