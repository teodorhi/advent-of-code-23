package day9

import println
import readInput

fun main() {
    val input = readInput("day9/data/input")
        .map { s -> s.split(" ").map { it.toInt() } }

    input.sumBy {
        getNext(listOf(it)).reversed().fold(0) { acc, layer -> layer.first() - acc }
    }.println()
}

private fun getNext(input: List<List<Int>>): List<List<Int>> =
    if (input.last().all { it == 0 }) input
    else getNext(input + listOf(input.last().zipWithNext { a, b -> b - a }))
