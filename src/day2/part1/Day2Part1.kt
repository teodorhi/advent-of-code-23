package day2.part1

import readInput

fun main() {
    val input = readInput("day2/data/input")
    val games: List<Game> = input.mapIndexed { i, s -> s.toGame(i + 1) }

    val legalGames = games.filterNot { game ->
        game.rounds.any { it.reds > 12 || it.greens > 13 || it.blues > 14 }
    }

    println(legalGames.sumOf { it.id })
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

data class Game(
    val id: Int,
    val rounds: List<Round>
)

data class Round(val reds: Int, val blues: Int, val greens: Int)
