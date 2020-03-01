package tfftcs.secondlab

/**
 * U*()
 */
fun operationalRecoverability(
    t: Int,
    n: Int,
    mu: Double,
    lambda: Double,
    m: Int,
    N: Int
): Double {
    var acc = 0.0
    for (i in (0 until n)) {
        var acc2 = 0.0
        for (l in (0 until n - i)) {
            acc2 += U(i, l, t, mu, m, N)
        }
        acc += P(i, mu, lambda, m) * acc2
    }
    return 1.0 - acc
}
