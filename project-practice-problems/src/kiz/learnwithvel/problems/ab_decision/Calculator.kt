package kiz.learnwithvel.problems.ab_decision

fun main() {

    var firstNumber = 0
    var secondNumber = 0

    println("Enter two numbers: ")
    firstNumber = readLine()!!.toInt()
    secondNumber = readLine()!!.toInt()

    print("Enter an operator (+, -, *, /): ")
    val operator = readLine()!!.toCharArray()[0]
    val result = when (operator) {
        '+' -> firstNumber + secondNumber
        '-' -> firstNumber - secondNumber
        '*' -> firstNumber * secondNumber
        '/' -> if (secondNumber >= 0) firstNumber / secondNumber
        else secondNumber / firstNumber
        else -> 0
    }

    println("$firstNumber $operator $secondNumber = $result")
}