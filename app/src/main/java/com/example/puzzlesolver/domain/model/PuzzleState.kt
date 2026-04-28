package com.example.puzzlesolver.domain.model

data class PuzzleState(
    val board: List<List<Int>>,
    val emptyY: Int,
    val emptyX: Int
) {
    fun isGoal(goalState: PuzzleState): Boolean {
        return this == goalState
    }

    fun createNextState(move: Move): PuzzleState? {
        val (newEmptyX, newEmptyY) = when (move) {
            Move.UP -> emptyX to emptyY - 1
            Move.DOWN -> emptyX to emptyY + 1
            Move.LEFT -> emptyX - 1 to emptyY
            Move.RIGHT -> emptyX + 1 to emptyY
        }
        
        val boardHeight = board.size
        val boardWidth = board[0].size
        
        if (newEmptyX !in 0..< boardWidth) return null
        if (newEmptyY !in 0..< boardHeight) return null
        
        val newBoard = board.map { it.toMutableList() }

        newBoard[emptyY][emptyX] = newBoard[newEmptyY][newEmptyX]
        newBoard[newEmptyY][newEmptyX] = 0
        
        val finalBoard = newBoard.map { it.toList() }

        return PuzzleState(finalBoard, newEmptyY, newEmptyX)
    }
}