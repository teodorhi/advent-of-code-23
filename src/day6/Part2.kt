package day6

import readInput

fun main() {
    val race = readInput("day6/data/input").map {
        it.substringAfter(": ").filterNot { it == ' ' }
    }.map { it.toLong() }

    val firstPossibleIndex = (1..race[0]).first { i ->  i * (race[0] - i) > race[1] }

    println(race[0] + 1 - (firstPossibleIndex * 2))
}
