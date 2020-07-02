package kiz.learnwithvel.problems.aa_introduction

fun main() {

    var num1 = 5
    var num2 = 10
    val temp = num1
    num1 = num2
    num2 = temp

    println("$num1 and $num2")

    num1 = 5
    num2 = 10

    num1 += num2
    num2 = num1 - num2
    num1 -= num2

    println("$num1 and $num2")


}

