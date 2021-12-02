fun main() {
    fun part1(input: List<String>): Int {
        val split = input.map { it.split(" ")}
        var (horizontal, depth) = Pair(0,0)
        split.forEach {
            when(it[0]) {
                "forward" -> horizontal += it[1].toInt()
                "down" -> depth += it[1].toInt()
                "up" -> depth -= it[1].toInt()
            }
        }
        return horizontal*depth
    }

    fun part2(input: List<String>): Int {
        val split = input.map { it.split(" ")}
        var (horizontal, depth) = Pair(0,0)
        var aim = 0
        split.forEach {
            when(it[0]) {
                "forward" -> {
                    horizontal += it[1].toInt()
                    depth += aim * it[1].toInt()
                }
                "down" -> aim += it[1].toInt()
                "up" -> aim -= it[1].toInt()
            }
        }
        return horizontal*depth

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
