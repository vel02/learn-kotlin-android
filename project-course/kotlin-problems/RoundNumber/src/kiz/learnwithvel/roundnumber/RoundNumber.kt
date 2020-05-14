package kiz.learnwithvel.roundnumber

import java.text.DecimalFormat

fun main(args: Array<String>) {

    val num = 1.34567

    val decimalFormat = DecimalFormat("#,###.####")
    println("Rounded: ${decimalFormat.format(num)}")
}