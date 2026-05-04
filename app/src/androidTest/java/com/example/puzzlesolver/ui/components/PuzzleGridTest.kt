package com.example.puzzlesolver.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class PuzzleGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun puzzleGrid_displaysAllNumbers() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 0)

        composeTestRule.setContent {
           PuzzleGrid(numbers = numbers, onTileClick = { })
        }

        composeTestRule.onNodeWithText("1").assertIsDisplayed()
        composeTestRule.onNodeWithText("8").assertIsDisplayed()
    }
}