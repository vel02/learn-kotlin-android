package kiz.learnwithvel.problems.ab_decision

fun main() {

    print("Enter first number: ")
    val num1 = readLine()!!.toInt()
    print("Enter second number: ")
    val num2 = readLine()!!.toInt()
    print("Enter third number: ")
    val num3 = readLine()!!.toInt()

    var largest = if (num1 > num2 && num1 > num3) "$num1 is the largest"
    else if (num2 > num1 && num2 > num3) "$num2 is the largest"
    else "$num3 is the largest"

    println(largest)

    largest = when {
        num1 > num2 && num1 > num3 -> "$num1 is the largest"
        num2 > num1 && num2 > num3 -> "$num2 is the largest"
        else -> "$num3 is the largest"
    }

    println(largest)
}