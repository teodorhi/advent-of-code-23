package day4

import readInput

fun main() {
    val input = readInput("day4/data/input")

    val wins = input.map { card ->
        card.substringAfter(':').split('|')
            .map { it.trim().split("\\s+".toRegex()).toSet() }
            .let { it[0].intersect(it[1]).size }
    }

    val copies = MutableList(wins.size) { 1 }

    wins.forEachIndexed { i, v ->
        (i + 1..i + v).forEach {
            if (it < copies.size) copies[it] += copies[i]
        }
    }

    println(copies.sum())
}
