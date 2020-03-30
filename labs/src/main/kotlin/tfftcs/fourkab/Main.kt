package tfftcs.fourkab

fun main() {
}

/**
 * @return *first* is list of pair with r and t,
 *  *second* is m, and *third* is n
 */
fun generateTestData(): Triple<List<Pair<Int, Int>>, Int, Int> {
    TODO()
}

fun `T(S)`(tau: List<Double>, t: List<Double>): Double? {
    if (tau.size != t.size) {
        return null
    }
    val resList = mutableListOf<Double>()
    var i = 0
    while (i < tau.size) {
        resList.add(tau[i] + t[i])
        i++
    }
    return resList.max()
}

/**
 * task contain [w as width] and [h as height] or [r as rang] and [t as time]
 * @return S()
 */
fun NFD(tasks: List<Pair<Int, Int>>, n: Int): List<Int> {
    tasks.sortedWith(Comparator { task1, task2 ->
        if (task1.second < task2.second) {
            -1
        } else if (task1.second == task2.second) {
            0
        } else {
            1
        }
    })

    var level = 0

    val lineByLevel = mutableListOf(mutableListOf(tasks.first()))

    for (task in tasks) {
        if (tasks.first() == task) {
            continue
        }
        if ((n - lineByLevel[level].last().first) >= tasks.maxBy { it.first }?.first ?: 0) {
            lineByLevel[level].add(task)
        } else {
            level++
            lineByLevel[level].add(task)
        }
    }

    lineByLevel.forEach { r ->
        r.forEach {
            print("$it\t")
        }
        println()
    }

    return createS(lineByLevel)
}

/**
 * @return S()
 */
fun FFD(r: List<Int>, t: List<Int>, m: Int, n: Int): List<Int> {
    TODO()
}

fun createS(levels: List<List<Pair<Int, Int>>>): List<Int> {
    TODO()
}
