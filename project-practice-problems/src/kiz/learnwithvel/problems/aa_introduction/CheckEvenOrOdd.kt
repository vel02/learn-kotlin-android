package kiz.learnwithvel.problems.aa_introduction

fun main() {

    println(check(56))

}

private fun check(number: Int) = if (number % 2 == 0) "even" else "odd"