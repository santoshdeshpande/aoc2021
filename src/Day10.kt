import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        val scores = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
        var invalids = input.map { p ->
            p.isValidParen()
        }.filter { it -> it.first != '-' }.groupBy { it }
        val result = invalids.map {
            scores[it.key.first]?.times(it.value.size) ?: 1
        }.sum()
//        println(result)
        return result
    }

    fun part2(input: List<String>): Long {
        val matching = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

        val incompletes = input.map { p ->
            p.isValidParen()
        }.filter { it -> it.first == '-' }
            .map {
                it.second.map {
                    matching[it!!]
                }.reversed()
            }
        val sums = incompletes.map {
            calculateScore(it)
        }.filter { it != 0L }.sorted()
        println(sums)
        println(sums.size)
        return sums[sums.size/2]
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 26397)
//    check(part2(testInput) == 288957)


    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}

fun calculateScore(list: List<Char?>): Long {
    println(list)
    val scores = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)
    val sum =
        list.fold(0L) { acc, c ->
            println("$acc <> $c -- ${scores[c]!!}")
            (5 * acc) + scores[c]!!
        }
    println(sum)
    return sum
}

fun String.isValidParen(): Pair<Char, Stack<Char>> {
    val opens = listOf<Char>('[', '{', '(', '<')
    val matching = mapOf(')' to '(', ']' to '[', '}' to '{', '>' to '<')
    val lst = this.toList()
    val stack = Stack<Char>()

    for (nextChar in lst) {

        if (nextChar in opens) {
            stack.push(nextChar)
        } else {
            val topChar = stack.peek()
            val expectedChar = matching[nextChar]
            if (topChar != expectedChar) {
                return Pair(nextChar, stack)
            } else {
                stack.pop()
            }
        }
    }
//    println(stack)
    return Pair('-', stack)
}

