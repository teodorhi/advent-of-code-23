package day8

import println
import readInput

fun main() {
    val input = readInput("day8/data/input")
    val sequence = input[0]

    val map = input.subList(2, input.size).associate {
        it.substring(0..2) to (it.substring(7..9) to it.substring(12..14))
    }

    val periods = map.map { it.key }.filter { it.endsWith("A") }.map { start ->
        var i = 0
        var current = start

        while (true) {
            val left = sequence[i % sequence.length] == 'L'
            current = if (left) map[current]!!.first else map[current]!!.second

            i++

            if (current.endsWith('Z')) break
        }

        i.toLong()
    }

    periods.reduce { a, i ->
        val gcd = (0..i).reversed().first { a % it == 0L && i % it == 0L }
        a * (i / gcd)
    }.println()
}
