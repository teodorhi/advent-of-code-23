package day6

import readInput

fun main() {
    val race = readInput("day6/data/input").map {
        it.substringAfter(": ").filterNot { it == ' ' }
    }.map { it.toLong() }

    var i = 1

    while (i * (race[0] - i) <= race[1]) {
        i++
    }

    println(race[0] + 1 - (i * 2))
}
