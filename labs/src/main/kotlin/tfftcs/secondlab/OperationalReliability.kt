package tfftcs.secondlab

/**
 * R*()
 */
fun operationalReliability(
    nBig: Int,
    nLittle: Int,
    lambda: Double,
    mu: Double,
    t: Int
): Double {
    var acc = 0.0
    for (i in (nLittle..nBig)) {
        var acc2 = 0.0
        for (r in (0..i-nLittle)) {
            acc2 += Pi(r, t, i, lambda)
        }
        acc += P(i, mu, lambda, 1) * acc2
    }
    return acc
}
