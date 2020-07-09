package kiz.learnwithvel.problems.ab_decision

import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {

    val low = 999
    val high = 99999

    for (i in (low + 1) until high) {
        var number = i
        var result = 0
        var digits = 0

        while (number != 0) {
            digits++
            number /= 10
        }

        number = i

        while (number != 0) {
            val value = (number % 10)
            result = (result + (value.toDouble().pow(digits.toDouble())).roundToInt())
            number /= 10
        }

        if (i == result) print("$i ")
    }
}