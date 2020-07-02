package kiz.learnwithvel.problems.aa_introduction

fun main() {


    val str = "This website is awesome."
    val ch = 'e'
    var frequency = 0

    for (i in str.indices) {
        if (ch == str[i])
            ++frequency
    }

    println(frequency)

}