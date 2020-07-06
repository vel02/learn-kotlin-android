package kiz.learnwithvel.problems.ab_decision

fun main() {

    //0 1 1 2 3 5 8...

    val iterate = 7

    var op1 = 0
    var op2 = 1

    print("0 1 ")
    for (i in 1..(iterate - 2)) {
        val sum = op1 + op2
        op1 = op2
        op2 = sum
        print("$sum ")
    }

    var i = 1
    op1 = 0
    op2 = 1
    print("\n0 1 ")
    while (i in 1..(iterate - 2)) {
        val sum = op1 + op2
        op1 = op2
        op2 = sum
        print("$sum ")
        i++
    }

}