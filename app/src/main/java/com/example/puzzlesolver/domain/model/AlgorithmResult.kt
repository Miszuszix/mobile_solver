package com.example.puzzlesolver.domain.model

data class AlgorithmResult(
    val solutionNode: Node?,
    val generatedStates: Int,
    val visitedStates: Int
)