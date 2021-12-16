fun main() {
    fun part1(input: List<String>): Long {
        val template = input.first()
        val rules = input
            .takeLastWhile { it.isNotEmpty() }
            .groupBy({ it.substringBefore(" -> ") }, { it.substringAfter(" -> ") })
            .mapValues { it.value.single() }
        val initial = template.windowed(2).groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        val pairsCount = (0 until 40).fold(initial) { current, _ ->
            buildMap {
                current.forEach { (pair, count) ->
                    val first = pair[0] + rules.getValue(pair)
                    val second = rules.getValue(pair) + pair[1]
                    put(first, getOrDefault(first, 0) + count)
                    put(second, getOrDefault(second, 0) + count)
                }
            }
        }
        val charsCount = buildMap<Char, Long> {
            put(template[0], 1)
            pairsCount.forEach { (pair, count) ->
                put(pair[1], getOrDefault(pair[1], 0) + count)
            }
        }

        return charsCount.maxOf { it.value } - charsCount.minOf { it.value }
    }

    fun part2(input: List<String>): Long {
        var newElements = "1163751742".windowed(1).toMutableList()
        for(i in 0..4) {
            println(i)
        }

        return -1
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day14_test")
//    check(part1(testInput) == 1588L)
//    check(part2(testInput) == 288957)


    val input = readInput("Day14")
    println(part1(input))
    println(part2(input))
}