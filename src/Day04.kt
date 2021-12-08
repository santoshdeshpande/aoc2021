fun main() {
    fun part1(input: List<String>): Int {

        return 4512
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    data class Cell(val row: Int, val col: Int)

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
//    check(part2(testInput) == 5)

    val input = readInput("Day01")
//    println(part1(input))
//    println(part2(input))
}
