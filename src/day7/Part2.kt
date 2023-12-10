package day7

import println
import readInput

fun main() {
    val input = readInput("day7/data/input").map { it.split(" ") }
    val cards = mutableMapOf(
        'A' to 'E', 'K' to 'D', 'Q' to 'C', 'J' to '1', 'T' to 'A', '2' to '2',
        '3' to '3', '4' to '4', '5' to '5', '6' to '6', '7' to '7', '8' to '8', '9' to '9',
    )

    val sortedHands = input.sortedBy { p ->
        val hand = p[0].groupingBy { it }.eachCount().toMutableMap()
        val jokers = hand['J']
        hand.remove('J')

        val bestHand = hand.map { it.value }.sortedDescending().mapIndexed { i, v ->
            if (i == 0) v + (jokers ?: 0) else v
        }.ifEmpty { listOf(5) }

        val text = bestHand.joinToString("").padEnd(5, '0')

        text + p[0].map { cards[it] }.joinToString("")
    }

    sortedHands
        .map { it[1].toInt() }
        .reduceIndexed { index, acc, int -> acc + int * (index + 1) }
        .println()
}
