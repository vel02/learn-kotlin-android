package kiz.learnwithvel.problems.aa_introduction

fun main(args: Array<String>) {

    print("Enter first number: ")
    val firstNumber = read().toInt()
    print("Enter second number: ")
    val secondNumber = read().toInt()

    println("Sum is ${sum(firstNumber, secondNumber)}")
}

private fun sum(a: Int, b: Int) = a + b

private fun read() = readLine()!!

