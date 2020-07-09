package kiz.learnwithvel.problems.ab_decision

fun main() {

    var number = 1234567
    var reversed = 0
    while (number != 0) {
        reversed = (reversed * 10) + (number % 10)
        number /= 10
    }

    println("Reversed number: $reversed")

}