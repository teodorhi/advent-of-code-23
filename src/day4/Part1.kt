package day4

import println
import readInput
import kotlin.math.pow

fun main() {
    val input = readInput("day4/data/input")

    input.sumOf { card ->
        val winCount = card.substringAfter(':').split('|')
            .map { it.trim().split("\\s+".toRegex()).toSet() }
            .let { it[0].intersect(it[1]).size }

        if (winCount == 0) 0
        else 2 pow (winCount - 1)
    }.println()
}

infix fun Int.pow(exponent: Int): Int = toDouble().pow(exponent).toInt()
