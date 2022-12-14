package tfftcs.secondlab

import tfftcs.firstlab.format
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        `compute S`()
        `compute operational reliability`()
        `compute operational recoverability`()
    }.also {
        println("Elapsed time is $it millis")
    }
}

fun compute(xList: List<Int>, yList: List<Int>, block: (x: Int, y: Int) -> Double) {
    print("\t\t")
    xList.forEach { x ->
        print("%8d\t".format(x))
    }
    println()
    yList.forEach { y ->
        print("%8d\t".format(y))
        xList.forEach { x ->
            print("${block(x, y).format(8, 8)}\t")
        }
        println()
    }
}

fun `compute operational reliability`() {
    println("--- compute compute operational reliability")
    val N = 10
    val lambda = 0.024
    val mu = 0.71

    // for (n in (8..10)) {
    //     for (t in (0..24 step 2)) {
    //         operationalReliability(N, n, lambda, mu, t)
    //             .also {
    //                 println("$n $t ${it.format(20)}")
    //             }
    //     }
    // }
    compute(
        (8..10).toList(),
        (0..24 step 2).toList()
    ) { x, y ->
        operationalReliability(N, x, lambda, mu, y)
    }
}

fun `compute operational recoverability`() {
    println("--- compute compute operational recoverability")
    val N = 16
    val lambda = 0.024
    val mu = 0.71
    val m = 1

    // for (n in (10..16)) {
    //     for (t in (0..24 step 2)) {
    //         operationalRecoverability(t, n, mu, lambda, m, N)
    //             .also {
    //                 println("$n $t ${it.format(10)}")
    //             }
    //     }
    // }
    compute(
        (10..16).toList(),
        (0..24 step 2).toList()
    ) { x, y ->
        operationalRecoverability(y, x, mu, lambda, m, N)
    }
}

fun `compute S`() {
    println("--- compute s")
    val lambda = 0.024
    val mu = 0.71
    // for (n in (11..16)) {
    //     for (m in listOf(1,16)) {
    //         availabilityFactor(n, m.toDouble(), mu, lambda)
    //             .also {
    //                 println("$n $m ${it.format(10)}")
    //             }
    //     }
    // }
    compute(
        (11..16).toList(),
        listOf(1, 16)
    ) { x, y ->
        availabilityFactor(x, y.toDouble(), mu, lambda)
    }
}
