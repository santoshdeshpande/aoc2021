fun main() {
    fun part1(input: List<Int>): Int {
        return input.filterIndexed {index, num -> index != 0 && num > input[index-1]}.size
    }

    fun part2(input: List<Int>): Int {
        val seq = input.asSequence()
        val windows = seq.windowed(step=1, size=3).map { it.sum() }
        return part1(windows.toList())
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputInt("Day01")
    println(part1(input))
    println(part2(input))
}
