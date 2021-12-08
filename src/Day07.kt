import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        val crabsPosition = input.first().split(",").map { it.toInt() }.sorted()
        val median = crabsPosition[crabsPosition.size/2]
        return crabsPosition.sumOf { x -> abs(median - x ) }
    }

    fun part2(input: List<String>): Int {
        fun sumOfNaturalNumbers(n: Int): Int {
            return (n * (n + 1))/2
        }

        val crabsPosition = input.first().split(",").map { it.toInt() }.sorted()
        val avg = floor(crabsPosition.average()).toInt()
        return crabsPosition.sumOf { x -> sumOfNaturalNumbers(abs(avg - x)) }
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 170)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}
