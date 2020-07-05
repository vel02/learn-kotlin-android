package kiz.learnwithvel.problems.ab_decision

fun main() {

    print("enter first number: ")
    val number = readLine()!!.toInt();

    var result = if (number > 0) "number is positive"
    else if (number < 0) "number is negative"
    else "number is zero"

    println(result)

    result = when {
        number > 0 -> "number is positive"
        number < 0 -> "number is negative"
        else -> "number is zero"
    }

    println(result)

}