package day8

import readInput

fun main() {
    val input = readInput("day8/data/input")
    val sequence = input[0]

    val map = input.subList(2, input.size).associate {
        it.substring(0..2) to (it.substring(7..9) to it.substring(12..14))
    }

    var i = 0
    var current = "AAA"

    while (true) {
        current =
            if (sequence[i % sequence.length] == 'L') map[current]!!.first
            else map[current]!!.second

        if (current == "ZZZ") {
            println(i + 1)
            break
        }
        i++
    }
}
