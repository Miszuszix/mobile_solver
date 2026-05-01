package com.example.puzzlesolver.domain.model

data class PuzzleState(
    val board: IntArray,
    val width: Int,
    val height: Int,
    val emptyY: Int,
    val emptyX: Int
) {
    operator fun get(y: Int, x: Int): Int = board[y * width + x]

    fun createNextState(move: Move): PuzzleState? {
        val newEmptyY = when (move) {
            Move.UP -> emptyY - 1
            Move.DOWN -> emptyY + 1
            else -> emptyY
        }
        val newEmptyX = when (move) {
            Move.LEFT -> emptyX - 1
            Move.RIGHT -> emptyX + 1
            else -> emptyX
        }

        if (newEmptyX !in 0..<width || newEmptyY !in 0..<height) return null

        val newBoard = board.copyOf()
        val oldPosition = emptyY * width + emptyX
        val newPosition = newEmptyY * width + newEmptyX

        newBoard[oldPosition] = newBoard[newPosition]
        newBoard[newPosition] = 0

        return PuzzleState(newBoard, width, height, newEmptyY, newEmptyX)
    }

    fun isSolvable(): Boolean {
        var inversions = 0
        val boardWithoutZero = board.filter { it != 0 }

        for (i in 0..<boardWithoutZero.size) {
            for (j in i + 1..<boardWithoutZero.size) {
                if (boardWithoutZero[i] > boardWithoutZero[j]) {
                    inversions++
                }
            }
        }

        return if (width % 2 != 0) {
            inversions % 2 == 0
        } else {
            val emptyRowFromBottom = height - emptyY
            (inversions + emptyRowFromBottom) % 2 != 0
        }
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PuzzleState) return false
        return width == other.width && height == other.height && board.contentEquals(other.board)
    }

    override fun hashCode(): Int {
        var result = board.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        return result
    }
}