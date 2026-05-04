package com.example.puzzlesolver.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.sqrt

/**
 * Komponent wyświetlający siatkę klocków.
 * 
 * @param numbers Lista liczb do wyświetlenia (np. [1, 2, 3, 0...])
 * @param onTileClick Callback wywoływany, gdy użytkownik kliknie w konkretną liczbę
 */
@Composable
fun PuzzleGrid(
    numbers: List<Int>,
    onTileClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
        val gridSize = sqrt(numbers.size.toDouble()).toInt()

        LazyVerticalGrid(
            columns = GridCells.Fixed(gridSize),
            modifier = modifier,
            contentPadding = PaddingValues(4.dp)
        ) {
            items(numbers) { number ->
                PuzzleTile(number, onClick = { onTileClick(number) })
            }
        }
}