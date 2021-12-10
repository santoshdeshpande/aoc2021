
fun main() {
    fun part1(input: List<String>): Int {
        val valves = input.map {
            it.toList().map { it.digitToInt() }
        }
        val rowCount = valves.size
        val colCount = valves.first().size
        val mins = mutableListOf<Int>()
        for (i in 0..rowCount-1) {

            for (j in 0..colCount-1) {
                val current = valves[i][j]
                var left = 100_000_000
                var right = 100_000_000
                var top = 100_000_000
                var bottom = 100_000_000
                if(j - 1 >= 0) {
                    left = valves[i][j-1]
                }
                if(j + 1 < colCount) {
                    right = valves[i][j+1]
                }
                if(i - 1 >= 0) {
                    top = valves[i-1][j]
                }
                if(i + 1 < rowCount) {
                    bottom = valves[i+1][j]
                }
                if(current < left && current < right && current < top && current < bottom) {
                    mins.add(current)
                }
            }
        }
        return mins.map { it + 1}.sum()
    }

    fun part2(input: List<String>): Int {
        val valves = input.map {
            it.map { it.digitToInt() }.toMutableList()
        }
        val grid = valves.toMutableList()
        val rowCount = valves.size
        val colCount = valves.first().size
        var result = mutableListOf<Int>()
        var finalResult = mutableListOf<Int>()
        for(i in 0..rowCount-1) {

            for(j in 0..colCount-1) {
                if(grid[i][j] != 9) {
                    result.clear()
                    dfs(grid, i, j, result)
                    finalResult.add(result.size)
                }
            }
        }
        finalResult.sortDescending()
        val res = finalResult.take(3).reduce(Int::times)
        println(res)
        return 26
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day09_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 26)

    val input = readInput("Day09")
    println(part1(input))
    println(part2(input))
}

fun dfs(grid: MutableList<MutableList<Int>>, row: Int, col: Int, result: MutableList<Int>) {
    val rowCount = grid.size
    val colCount = grid.first().size

    if(row < 0 || col < 0 || row >= rowCount || col >= colCount || grid[row][col] == 9) {
        return
    }

//    println(grid[row][col])
    result.add(grid[row][col])
    grid[row][col] = 9

    dfs(grid, row+1, col, result)
    dfs(grid, row-1,col, result)
    dfs(grid, row, col+1, result)
    dfs(grid, row, col-1, result)

}