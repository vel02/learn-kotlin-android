package kiz.learnwithvel.gcd

fun main(args: Array<String>) {

    var operand1 = 81
    var operand2 = 153


    if (operand1 < operand2) {
        operand2 += operand1
        operand1 = operand2 - operand1
        operand2 -= operand1
    }

//    var gcd = 1
//    var i = 1
//
//    while (i <= operand1 && i <= operand2) {
//
//        if (operand1 % i == 0 && operand2 % i == 0)
//            gcd = i
//        i++
//
//    }

    //pattern
    while (operand1 != operand2) {
        if (operand1 > operand2)
            operand1 -= operand2
        else operand2 -= operand1
    }
    println(operand1)

}