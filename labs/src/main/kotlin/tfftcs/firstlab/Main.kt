package tfftcs.firstlab

fun Double.format(digits: Int) = "%.${digits}f".format(this)

fun main() {
    compute21()
    compute22()
    compute23()
}

fun compute23() {
    println("--- task 2.3")
    val nBig = 65536
    val mu = 1.0
    val lambda = 1.0E-5
    (1..4).forEach { m ->
        (65527..65536).forEach { nLittle ->
            ExpectedValue.compute(
                nBig,
                nLittle,
                lambda,
                mu,
                m.toDouble()
            ).also {
                println("$nLittle $m ${it.format(2)}")
            }
        }
    }
    println("---")
}

fun compute22() {
    println("--- task 2.2")
    val nBig = 65536
    val mu = 1.0
    val m = 1.0
    for (lambda in listOf(1.0E-5, 1.0E-6, 1.0E-7, 1.0E-8, 1.0E-9)) {
        (65527..65536).forEach { nLittle ->
            ExpectedValue.compute(
                nBig,
                nLittle,
                lambda,
                mu,
                m
            ).also {
                println("$nLittle $lambda ${it.format(2)}")
            }
        }
    }
    println("---")
}

fun compute21() {
    println("--- task 2.1")
    val nBig = 65536
    val lambda = 1.0E-5
    val m = 1.0
    for (mu in listOf(1, 10, 100, 1000)) {
        (65526..65536).forEach { nLittle ->
            ExpectedValue.compute(
                nBig,
                nLittle,
                lambda,
                mu.toDouble(),
                m
            ).also {
                println("$mu $nLittle ${it.format(2)}")
            }
        }
    }
    println("---")
}
