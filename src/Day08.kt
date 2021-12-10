fun main() {
    fun part1(input: List<String>): Int {
        val digits = input.map { it.split(" | ").last().split(" ") }.flatten()
        return digits.count { digit ->
            digit.length in listOf(2, 3, 4, 7)
        }
    }

    fun part2(input: List<String>): Int {

        val r = input.map { it.split(" | ") }.sumOf {
            fun1(it.first(), it.last())
        }

        return r
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 61229)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}


fun fun1(input:String, input2: String): Int {

    val x = input.split(" ").map { it.toCharArray().sorted().joinToString("") }

    val map = mutableMapOf<Int, String>()
    x.forEach {
        when (it.length) {
            2 -> map[1] = it
            3 -> map[7] = it
            4 -> map[4] = it
            7 -> map[8] = it
        }
    }
    val fives = x.filter { it.length == 5 }
        .filter { it ->
            val ones = Regex("[" + map[1] + "]")
            if (it.replace(ones, "").length == 3) {
                map[3] = it
                false
            } else {
                true
            }

        }
    var sixes = x.filter { it.length == 6 }

    sixes.forEach { it ->
        val ones = Regex("[" + map[1] + "]")
        if (it.replace(ones, "").length == 5) {
            map[6] = it

        }
    }
    fives.forEach {
        val six = Regex("[" + map[6] + "]")
        if (six.replace(it, "").isEmpty()) {
            map[5] = it
        }
    }
    fives.forEach {
        if(it != map[5] && it != map[3]) {
            map[2] = it
        }
    }

    map[9] = (map[5] + map[1]).toCharArray().toSet().sorted().joinToString("")
    sixes = sixes.filter { it != map[6] && it != map[9]}
    map[0] = sixes.single()
    val reverseMap: Map<String, Int> = map.entries.associate { (key, value) -> value to key }
    val vals = input2.split(" ").map { it.toCharArray().sorted().joinToString("") }
    var result = vals.map {
        reverseMap[it]
    }.joinToString("")
    return result.toInt()
}