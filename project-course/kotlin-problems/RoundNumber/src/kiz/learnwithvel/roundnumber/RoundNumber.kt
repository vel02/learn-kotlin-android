package kiz.learnwithvel.roundnumber

import java.math.RoundingMode
import java.text.DecimalFormat

fun main(args: Array<String>) {

    val num = 1.34567

    val decimalFormat = DecimalFormat("#,###.###")
    decimalFormat.roundingMode = RoundingMode.CEILING// rounding last decimal digit.
    println("Rounded: ${decimalFormat.format(num)}")
}