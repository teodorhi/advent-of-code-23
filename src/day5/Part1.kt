package day5

import println
import readInput

fun main() {
    val parts = readInput("day5/data/input").joinToString().split(", , ")
    val seeds = parts[0].substringAfter(": ").split(" ").map { it.toLong() }

    val maps = parts.subList(1, 8).map { part ->
        part.substringAfter(":, ").split(",").map {
            it.trim().split(" ").map { n -> n.toLong() }
        }
    }

    seeds.minOf { seed ->
        maps.fold(seed) { acc, triple ->
            triple.firstOrNull { t -> acc in t[1]..<t[1] + t[2] }
                ?.let { (it[0] + acc) - it[1] }
                ?: acc
        }
    }.println()
}
