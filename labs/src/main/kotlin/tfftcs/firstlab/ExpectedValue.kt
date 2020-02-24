package tfftcs.firstlab

object ExpectedValue {

    fun compute(
        nBig: Int, // Total count of the computers
        nLittle: Int, // Count of the core computers
        lambda: Double, // Failure rate
        mu: Double, // Recovery intensity
        m: Double // Count of the recovery computers
    ): Double {

        var acc = 0.0
        (nLittle+1..nBig).forEach { j ->
            var acc2 = 1.0
            (nLittle until j).forEach { i ->
                acc2 *= (getMuI(nBig.toDouble(), m, i.toDouble(), mu) / (i * lambda))
            }
            acc += (1.0 / (j * lambda)) * acc2
        }

        return acc + (1.0 / (nLittle * lambda))
    }
}
