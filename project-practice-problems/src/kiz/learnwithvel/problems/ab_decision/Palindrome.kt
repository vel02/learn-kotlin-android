package kiz.learnwithvel.problems.ab_decision

fun main() {

    val input = 121
    var number = input
    var reversed = 0
    while (number != 0) {
        reversed = (reversed * 10) + (number % 10)
        number /= 10
    }

    val result = if (reversed == input) "$input, is a palindrome"
    else "$input, is not a palindrome"
    println(result)

}