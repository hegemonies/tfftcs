package tfftcs.secondlab

import kotlin.math.exp
import kotlin.math.pow

fun availabilityFactor(
    n: Int,
    m: Double,
    mu: Double,
    lambda: Double
): Double {
    var acc = 0.0

    (0 until n).forEach { j ->
        acc += ((m * mu) / lambda).pow(j.toDouble()) * (exp(-((m * mu) / lambda)) / factorial(j))
    }

    return 1.0 - acc
}
