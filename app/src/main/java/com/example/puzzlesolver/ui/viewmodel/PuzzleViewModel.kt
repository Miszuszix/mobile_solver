package com.example.puzzlesolver.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.puzzlesolver.domain.model.Move
import com.example.puzzlesolver.domain.model.PuzzleState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PuzzleViewModel : ViewModel() {
    private val initialState = PuzzleState(
        board = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0),
        width = 3,
        height = 3,
        emptyY = 2,
        emptyX = 2
    )
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<PuzzleState> = _uiState.asStateFlow()

    fun onTileClicked(number: Int) {
        val currentState = _uiState.value

        val tileIndex = currentState.board.indexOf(number)
        val tileY = tileIndex / currentState.width
        val tileX = tileIndex % currentState.width

        val dy = tileY - currentState.emptyY
        val dx = tileX - currentState.emptyX
        
        val move = when(dy to dx){
            (-1 to 0) -> Move.UP
            (1 to 0) -> Move.DOWN
            (0 to -1) -> Move.LEFT
            (0 to 1) -> Move.RIGHT
            else -> null
        }
        
        if(move != null){
            val nextState = currentState.createNextState(move)
            if(nextState != null){
                _uiState.value = nextState
            }
        }
    }
}