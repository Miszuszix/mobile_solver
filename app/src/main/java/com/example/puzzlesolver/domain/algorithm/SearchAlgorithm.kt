package com.example.puzzlesolver.domain.algorithm

import com.example.puzzlesolver.domain.model.AlgorithmResult
import com.example.puzzlesolver.domain.model.PuzzleState

interface SearchAlgorithm {
    suspend fun solve(
        initialState: PuzzleState,
        goalState: PuzzleState,
    ): AlgorithmResult
}