fun main() {
    fun part1(input: List<String>): Int {
        val z = input.map { x ->
            x.trim()
                .split("")
                .filter { z -> z != "" }
                .map { n -> n.toInt() }
        }.transpose()
        val mostCommonBits = z.map { if (it.average() > 0.5) 1 else 0 }
        val leastCommonBits = mostCommonBits.map { it.xor(1) }
        val gamma = mostCommonBits.joinToString("").toInt(2);
        val epsilon = leastCommonBits.joinToString("").toInt(2)
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        var index = 0
        var inputList = input
        while(index != input[0].length) {
            inputList = filterListWithMost(inputList, index)
            if(inputList.size == 1) break;
            index++;
        }
        var oxygenRating = inputList[0].toInt(2)
        println(oxygenRating)

        index = 0
        inputList = input
        while(index != input[0].length) {
            inputList = filterListWithLeast(inputList, index)
            if(inputList.size == 1) break;
            index++;
        }

        var coRating = inputList[0].toInt(2)
        println(coRating)
        return oxygenRating*coRating
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

}

fun filterListWithMost(input: List<String>, index: Int) : List<String> {
    val z = input.map { x ->
        x.trim()
            .split("")
            .filter { z -> z != "" }
            .map { n -> n.toInt() }
    }.transpose()
    val mostCommonBits = z.map { if (it.average() >= 0.5) 1 else 0 }
    return input.filter { char ->
        char[index].toString().toInt() == mostCommonBits[index]
    }
}

fun filterListWithLeast(input: List<String>, index: Int) : List<String> {
    val z = input.map { x ->
        x.trim()
            .split("")
            .filter { z -> z != "" }
            .map { n -> n.toInt() }
    }.transpose()
    val mostCommonBits = z.map { if (it.average() >= 0.5) 1 else 0 }
    val leastCommonBits = mostCommonBits.map { it.xor(1) }
    return input.filter { char ->
        char[index].toString().toInt() == leastCommonBits[index]
    }
}