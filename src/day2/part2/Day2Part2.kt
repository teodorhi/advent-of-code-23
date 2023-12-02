package day2.part2

import readInput

fun main() {
    val input = readInput("day2/data/input")
    val games: List<Game> = input.mapIndexed { i, s -> s.toGame(i + 1) }

    val powers = games.sumOf { game ->
        val reds = game.rounds.maxOfOrNull { it.reds } ?: 0
        val greens = game.rounds.maxOfOrNull { it.greens } ?: 0
        val blues = game.rounds.maxOfOrNull { it.blues } ?: 0

        reds * greens * blues
    }

    println(powers)
}

private fun String.toGame(id: Int): Game {
    val gameString = substring(indexOf(":") + 1)

    val rounds = gameString.split(";").map { roundString ->
        val colors = roundString.split(",")
        return@map Round(
            reds = colors.getContaining("red"),
            blues = colors.getContaining("blue"),
            greens = colors.getContaining("green"),
        )
    }

    return Game(id, rounds)
}

fun List<String>.getContaining(character: String): Int {
    return firstOrNull { it.contains(character) }?.trim()?.split(" ")?.firstOrNull()?.toInt() ?: 0
}

data class Game(val id: Int, val rounds: List<Round>)

data class Round(val reds: Int, val blues: Int, val greens: Int)
