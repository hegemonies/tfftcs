package tfftcs.firstlab

object AverageRecoveryTime {

    fun compute(
        nLittle: Int,
        nBig: Int,
        lambda: Double,
        m: Double,
        mu: Double
    ): Double {
        if (nLittle == 1) {
            return (1 / getMuI(nBig.toDouble(), m, 0.0, mu))
        }
        val leftValue = computeLeftValue(nBig, nLittle, lambda, mu, m)
        val rightValue = computeRightValue(nBig, nLittle, lambda, m, mu)
        return leftValue + rightValue
    }

    private fun computeRightValue(
        nBig: Int,
        nLittle: Int,
        lambda: Double,
        m: Double,
        mu: Double
    ): Double {
        var acc = 0.0
        for (j in (1 until nLittle)) {
            var acc2 = 1.0
            for (i in (j until nLittle)) {
                acc2 *= (i * lambda) / getMuI(nBig.toDouble(), m, i.toDouble(), mu)
            }
            acc += acc2 * (1 / (j * lambda))
        }
        return acc
    }

    private fun computeLeftValue(
        nBig: Int,
        nLittle: Int,
        lambda: Double,
        mu: Double,
        m: Double
    ): Double {
        var acc = 1.0
        for (i in (1 until nLittle)) {
            acc *= (i * lambda) / getMuI(nBig.toDouble(), m, i.toDouble(), mu)
        }
        return acc / getMuI(nBig.toDouble(), m, 0.0, mu)
    }
}
