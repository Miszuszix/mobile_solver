package com.example.puzzlesolver.domain.model

enum class Move {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    fun opposite(): Move {
        return when(this){
            Move.UP -> Move.DOWN
            Move.DOWN -> Move.UP
            Move.RIGHT -> Move.LEFT
            Move.LEFT -> Move.RIGHT
        }
    }
}