package tfftcs.firstlab

fun getMuI(
    nBig: Double,
    m: Double,
    i: Double,
    mu: Double
): Double {
    if ((nBig - m) <= i && i <= nBig) {
        return (nBig - i) * mu
    }
    if (0 <= i && i < (nBig - m)) {
        return m * mu
    }

    return 1.0.also {
        println("WARN: getMuL returned 1,0")
    }
}
