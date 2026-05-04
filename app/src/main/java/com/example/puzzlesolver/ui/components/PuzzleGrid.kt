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

        // 2. Użyj LazyVerticalGrid
        LazyVerticalGrid(
            // TODO: Skonfiguruj stałą liczbę kolumn używając GridCells.Fixed(gridSize)
            columns = GridCells.Fixed(gridSize),
                modifier = modifier,
            // TODO: Dodaj odstępy między klockami (contentPadding) używając PaddingValues
            contentPadding = PaddingValues(4.dp)
        ) {
            // 3. Wypełnij siatkę elementami
            // Użyj funkcji items(numbers) { number -> ... }
            items(numbers) { number ->
                // TODO: Wywołaj Twój komponent PuzzleTile
                // Podaj mu odpowiedni numer i przekaż onTileClick
                PuzzleTile(number, onClick = { onTileClick(number) })
            }
        }
}