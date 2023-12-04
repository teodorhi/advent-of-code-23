package day4

import readInput

fun main() {
    val input = readInput("day4/data/input")

    val wins = input.map { card ->
        val (winners, numbers) = card.substringAfter(':').split('|')
            .map { it.trim().split("\\s+".toRegex()) }.let { it[0] to it[1] }

        numbers.filter { winners.contains(it) }.size
    }

    val copies = MutableList(wins.size) { 1 }

    wins.forEachIndexed { i, v ->
        (i + 1..i + v).forEach {
            if (it < copies.size) copies[it] += copies[i]
        }
    }

    println(copies.sum())
}
