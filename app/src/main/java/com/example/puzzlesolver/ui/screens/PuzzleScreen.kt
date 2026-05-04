package com.example.puzzlesolver.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.puzzlesolver.ui.components.PuzzleGrid
import com.example.puzzlesolver.ui.viewmodel.PuzzleViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PuzzleScreen(
    viewModel: PuzzleViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    PuzzleGrid(
        numbers = uiState.board.toList(),
        onTileClick = viewModel::onTileClicked
    )
}