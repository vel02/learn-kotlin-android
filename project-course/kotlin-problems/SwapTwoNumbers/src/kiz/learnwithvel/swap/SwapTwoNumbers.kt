package kiz.learnwithvel.swap

fun main(args: Array<String>) {

    solutionTwo()
}

fun solutionOne() {

    var num1 = 2.34f
    var num2 = 3.22f

    val temp = num1

    num1 = num2
    num2 = temp

    println("Number1: $num1")
    println("Number2: $num2")
}

fun solutionTwo() {
    var num1 = 2.34f
    var num2 = 3.22f

    num1 += num2
    num2 = num1 - num2
    num1 -= num2

    println("Number1: $num1")
    println("Number2: $num2")
}