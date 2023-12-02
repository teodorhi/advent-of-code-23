package day1.part2

import readInput

fun main() {
    val testInput = readInput("data/day1_input")

    val result = getFirstAndLastNumber(testInput)

    println(result.sum())
}

private fun getFirstAndLastNumber(input: List<String>): List<Int> {
    return input
        .map { entry -> getDigits(entry) }
        .map { "${it.first()}${it.last()}" }
        .map { it.toInt() }
}

private fun getDigits(entry: String): String {
    var data = entry
    numbers.forEach { data = data.replace(it.first, "${it.first}${it.second}${it.first}") }
    return data.filter { it.isDigit() }
}

val numbers = listOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9",
)
