package kiz.learnwithvel.problems.aa_introduction

fun main() {

    print("Enter first number: ")
    val operandOne = read().toInt()
    print("Enter second number: ")
    val operandTwo = read().toInt()

    println("The product of $operandOne * $operandTwo is ${product(operandOne, operandTwo)}")

}

private fun read() = readLine()!!

private fun product(operandOne: Int, operandTwo: Int) = operandOne * operandTwo