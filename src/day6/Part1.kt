package day6

import readInput

fun main() {
    val input = readInput("day6/data/input").map {
        it.substringAfter(": ").split(" ")
            .filterNot { s -> s == "" }.map { s -> s.toInt() }
    }

    val permutations = input[0].zip(input[1]).map { race ->
        val first = (1..race.first).first { it * (race.first - it) >= race.second }
        race.first + 1 - (first * 2)
    }

    println(permutations.reduce { acc, i ->
        i * acc
    })
}

