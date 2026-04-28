package com.example.puzzlesolver.domain.model

data class Node(
    val state: PuzzleState,
    val parent: Node? = null,
    val move: Move? = null,
    val depth: Int = 0,
    val cost: Int = 0
) : Comparable<Node> {

    fun expand(moveOrder: List<Move>): List<Node> {
        val neighbors = mutableListOf<Node>()

        for (move in moveOrder) {
            if (move == this.move?.opposite()) continue

            val nextState = this.state.createNextState(move)

            if (nextState != null){
                neighbors.add(Node(nextState, this, move, this.depth + 1))
            }
        }
        return neighbors
    }
    
    fun getPath(): List<Move> {
        val moves = mutableListOf<Move>()

        var currentNode: Node? = this

        while(currentNode != null){
            if(currentNode.move != null){
                    moves.add(currentNode.move)
            }
            currentNode = currentNode.parent
        }
        
        val finalMovesList = moves.reversed()
        return finalMovesList
    }
    
    override fun compareTo(other: Node): Int {
        return cost.compareTo(other.cost)
    }
}