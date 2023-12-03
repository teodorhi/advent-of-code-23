package day3

import readInput

fun main() {
    val input = readInput("day3/data/input").map { "$it." }

    val gears = buildList {
        input.forEachXYIndexed { x, y, s ->
            if (s == '*') add(x to y)
        }
    }

    val numbers = buildList {
        input.forEachIndexed { y, row ->
            row.foldIndexed("") { x, acc, c ->
                if (c.isDigit()) {
                    if (!row[x + 1].isDigit()) {
                        add(
                            IndexedNumber(
                                (x - acc.length - 1)..(x + 1),
                                (y - 1)..(y + 1),
                                (acc + c).toInt()
                            )
                        )
                        ""
                    } else acc + c
                } else ""
            }
        }
    }

    val sum = gears.sumOf { gear ->
        val gearNumbers = numbers.filter { gear.first in it.x && gear.second in it.y }
        if (gearNumbers.size == 2) gearNumbers[0].value * gearNumbers[1].value
        else 0
    }

    println(sum)
}

data class IndexedNumber(val x: IntRange, val y: IntRange, val value: Int)

private fun List<String>.forEachXYIndexed(operation: (Int, Int, Char) -> Unit) {
    forEachIndexed { y, row -> row.forEachIndexed { x, s -> operation(x, y, s) } }
}
