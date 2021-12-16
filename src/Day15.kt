import kotlin.math.min

fun main() {
    fun part1(input: List<String>): Int {
        val xx = input.map {
            it.windowed(1).map { it -> it.toInt() }
        }
        val startPos = Pair(0,0)
        val endPos = Pair(xx.size-1, xx[0].size-1)
        val weights = Array(xx.size) { Array(xx[0].size){0} }
        weights[0][0] = xx[0][0]
        //top row move to right
        for(i in 1..endPos.second) {
            weights[0][i] = weights[0][i-1] + xx[0][i]
        }
        for(i in 1..endPos.first) {
            weights[i][0] = weights[i-1][0] + xx[i][0]
        }

        for(i in 1..endPos.first) {
            for (j in 1..endPos.second) {
                weights[i][j] = xx[i][j] + min(weights[i-1][j], weights[i][j-1])
            }
        }
        return weights[endPos.first][endPos.second] - xx[0][0]
    }

    fun part2(input: List<String>): Long {
        val width: Int = input.first().length
        val height: Int = input.size
        return -1
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day15_test")
    check(part1(testInput) == 40)
    check(part2(testInput) == -1L)


    val input = readInput("Day15")
    println(part1(input))
//    println(part2(input))
}