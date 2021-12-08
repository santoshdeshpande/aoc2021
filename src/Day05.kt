fun main() {



    fun part1(input: List<String>): Int {

        return 5
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
//    check(part2(testInput) == 5)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))

}