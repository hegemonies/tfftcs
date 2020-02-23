package tfftcs.firstlab

import kotlin.math.pow

fun Double.format(digits: Int) = "%.${digits}f".format(this)

fun main() {
    for (mu in listOf(1,10,100,1000)) {
        (65526..65536).forEach { nLittle ->
            ExpectedValue.compute(
                65536,
                nLittle,
                1.0E-5,
                mu.toDouble(),
                1.0
            ).also {
                println("$mu $nLittle ${it.format(2)}")
            }
        }
    }
}
