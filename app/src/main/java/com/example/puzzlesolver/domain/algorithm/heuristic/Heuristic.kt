package com.example.puzzlesolver.domain.algorithm.heuristic

import com.example.puzzlesolver.domain.model.PuzzleState

interface Heuristic {
    fun calculate(state: PuzzleState): Int
}