package day3

import readInput

fun main() {
    val input = readInput("day3/data/input")

    val positions = mutableListOf<Pair<Int, Int>>()

    input.forEachXYIndexed { x, y, s ->
        if (!s.isDigit() && s != '.')
            (y - 1..y + 1).forEach { markedY ->
                (x - 1..x + 1).forEach { markedX ->
                    positions.add(markedX to markedY)
                }
            }
    }

    val numbers = mutableListOf<Int>()

    input.forEachIndexed { y, row ->
        var number = ""

        row.forEachIndexed { x, c ->
            if (c.isDigit()) {
                number += c
                if (row.length == x + 1 || !row[x + 1].isDigit()) {
                    val range = (x + 1 - number.length)..<x + 1
                    val positionOk = range.fold(false) { acc, int ->
                        acc || positions.contains(int to y)
                    }

                    if (positionOk) numbers.add(number.toInt())
                }
            } else {
                number = ""
            }
        }
    }

    println(numbers.sum())
}


private fun List<String>.forEachXYIndexed(operation: (Int, Int, Char) -> Unit) {
    forEachIndexed { y, row -> row.forEachIndexed { x, s -> operation(x, y, s) } }
}
