package day6

import readInput

fun main() {
    val input = readInput("day6/data/input").map {
        it.substringAfter(": ").split(" ")
            .filterNot { s -> s == "" }.map { s -> s.toInt() }
    }

    val permutations = input[0].zip(input[1]).map { race ->
        var i = 1
        while (i * (race.first - i) <= race.second) {
            i++
        }
        race.first + 1 - (i * 2)
    }

    println(permutations.reduce { acc, i ->
        i * acc
    })
}

