fun main() {
    fun part1(input: List<String>): Long {
        val fish = input.first().split(",").map {it.toInt()}
        var state = mutableListOf<Long>(0L,0L,0L,0L,0L,0L,0L,0L,0L)
        fish.forEach {
            state[it]++
        }
        for(i in 1..256) {
            val totalZeroes = state.first()
            val st = state.drop(1);
            state.removeAt(0)
            state[6] += totalZeroes
            state.add(totalZeroes)
        }
        println(state);
        return state.reduce { acc, l ->  acc + l}
//        return state.reduce { acc, n -> n + acc}

        return 100
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
//    part1(testInput)
    check(part1(testInput) == 26984457539)
//    check(part2(testInput) == 5)

    val input = readInput("Day06")
    println(part1(input))
//    println(part2(input))
}
