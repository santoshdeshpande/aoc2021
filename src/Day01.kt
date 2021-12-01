fun main() {
    fun part1(input: List<Int>): Int {
        return input.zipWithNext()
            .count { (prev, next) -> next > prev }
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(step = 1, size = 3) { it.sum() }
            .zipWithNext()
            .count { (prev, next) -> next > prev }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputInt("Day01")
    println(part1(input))
    println(part2(input))
}
