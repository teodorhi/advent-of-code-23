package day5

import println
import readInput

fun main() {
    val parts = readInput("day5/data/input").joinToString().split(", , ")
    val seeds = parts[0].substringAfter(": ").split(" ").map { it.toLong() }
        .zipWithNext { a, b -> a to a + b }
        .filterIndexed { i, _ -> i % 2 == 0 }

    val maps = parts.subList(1, 8).map { part ->
        part.substringAfter(":, ").split(",").map {
            it.trim().split(" ").map { n -> n.toLong() }
        }
    }

    seeds.minOf { seedRange ->
        mapSeeds(seedRange, maps)
    }.println()
}

fun mapSeeds(seedRange: Pair<Long, Long>, maps: List<List<List<Long>>>): Long {
    if (maps.isEmpty()) return seedRange.first

    val mappedParts = maps[0].mapNotNull {
        val fromRange = maxOf(it[1], seedRange.first) to minOf(it[1] + it[2], seedRange.second)
        if (fromRange.first > fromRange.second) null
        else {
            val toRange = fromRange.first + it[0] - it[1] to fromRange.second + it[0] - it[1]
            fromRange to toRange
        }
    }

    val unmappedParts = mappedParts.map { it.first }.fold(listOf(seedRange)) { acc, mapped ->
        buildList {
            acc.forEach {
                if (it.first < mapped.first) add(it.first to mapped.first)
                if (it.second > mapped.second) add(mapped.second to it.second)
            }
        }
    }

    return (mappedParts.map { it.second } + unmappedParts).minOf {
        mapSeeds(it, maps.subList(1, maps.size))
    }
}
