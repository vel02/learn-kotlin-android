package kiz.learnwithvel.problems.ab_decision

import kotlin.math.pow

fun main() {

    val base = 3
    var exponent = 4
    var power = 1.toLong()

    while (exponent > 0) {
        power *= base.toLong()
        exponent--
    }
    println("Answer: $power")
    exponent = 4

    println("Answer: ${(base.toDouble().pow(exponent.toDouble())).toInt()}")

}