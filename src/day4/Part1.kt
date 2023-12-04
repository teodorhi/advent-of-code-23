package day4

import println
import readInput
import kotlin.math.pow

fun main() {
    val input = readInput("day4/data/input")

    input.sumOf { card ->
        val (winners, numbers) = card.substringAfter(':').split('|')
            .map { it.trim().split("\\s+".toRegex()) }.let { it[0] to it[1] }

        val winCount = numbers.filter { winners.contains(it) }.size

        if (winCount == 0) 0
        else 2.0.pow(winCount - 1).toInt()
    }.println()
}
