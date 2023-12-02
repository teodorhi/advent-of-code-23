package day1.part1

import readInput

fun main() {
    val testInput = readInput("data/day1_input")

    println(getFirstAndLastNumber(testInput).sum())
}

fun getFirstAndLastNumber(input: List<String>): List<Int> {
    return input
        .map { entry -> entry.filter { it.isDigit() } }
        .map { "${it.first()}${it.last()}" }
        .map { it.toInt() }
}
