package kiz.learnwithvel.problems.aa_introduction

import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {

    val num = 1.34567
    println("%.4f".format(num))

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.CEILING
    println(df.format(num))

}