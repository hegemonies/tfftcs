package tfftcs.secondlab

import kotlin.math.exp
import kotlin.math.pow

fun factorial(num: Int): Int =
    when (num) {
        0 -> 1
        1 -> num
        else -> num * factorial(num - 1)
    }

fun P(
    j: Int,
    mu: Double,
    lambda: Double,
    m: Int
): Double =
    ((m * mu) / lambda) * (1.0 / factorial(j)) * exp(-((m * mu) / lambda))

fun Pi(
    r: Int,
    t: Int,
    i: Int,
    lambda: Double
) =
    (((i * lambda * t).pow(r)) / factorial(r)) * exp(-(i * lambda * t))

fun U(
    i: Int,
    l: Int,
    t: Int,
    mu: Double,
    m: Int,
    N: Int
) =
    (((mu * t).pow(l)) / factorial(l)) * (lambda(N - i - m) * m.toDouble().pow(l) * exp(-(i * mu * t)))+ (lambda(m - N + i) * (N - i).toDouble().pow(l) * exp(-((N - i) * mu * t)))

fun lambda(x: Int) =
    if (x >= 0) { 1 } else { 0 }


