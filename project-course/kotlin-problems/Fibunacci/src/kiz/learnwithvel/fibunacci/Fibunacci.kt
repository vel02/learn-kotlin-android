package kiz.learnwithvel.fibunacci


fun main(args: Array<String>) {

    var operand1 = 0
    var operand2 = 1
    val nth = 10

    for (i in 0 until nth) {

        print("$operand1, ")
        val sum = operand1 + operand2
        operand2 = operand1
        operand1 = sum

    }

    println()

    var i = 0
    operand1 = 0
    operand2 = 1
    while (operand1 <= nth) {

        print("$operand1, ")
        val sum = operand1 + operand2
        operand2 = operand1
        operand1 = sum
        i++
    }

}