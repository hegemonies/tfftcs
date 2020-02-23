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
                acc2 *= (getMuL(nBig.toDouble(), m, i.toDouble(), mu) / (i * lambda))
            }
            acc += (1.0 / (j * lambda)) * acc2
        }

        return acc + (1.0 / (nLittle * lambda))
    }

    private fun getMuL(
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
}

/*

1 65526    300,28
1 65527    195,76
1 65528    127,27
1 65529    82,40
1 65530    53,00
1 65531    33,73
1 65532    21,10
1 65533    12,83
1 65534    7,41
1 65535    3,85
1 65536    1,53
10 65526   1118208140299,72
10 65527   73271706601,18
10 65528   4801275118,36
10 65529   314617955,86
10 65530   20616599,93
10 65531   1351005,69
10 65532   88532,65
10 65533   5801,62
10 65534   380,10
10 65535   24,81
10 65536   1,53
100 65526  10518185272456235000000,00
100 65527  68921460816296740000,00
100 65528  451621656290947710,00
100 65529  2959386389343322,50
100 65530  19392563070727,84
100 65531  127079465802,47
100 65532  832764447,34
100 65533  5457271,97
100 65534  35763,13
100 65535  234,36
100 65536  1,53
1000 65526 104561058138309180000000000000000,00
1000 65527 68514678955708480000000000000,00
1000 65528 44895613679307100000000000,00
1000 65529 29419197731776363000000,00
1000 65530 19278106081655734000,00
1000 65531 12632942915309006,00
1000 65532 8278493821831,15
1000 65533 5425062571,32
1000 65534 3555206,25
1000 65535 2329,87
1000 65536 1,53

*/
