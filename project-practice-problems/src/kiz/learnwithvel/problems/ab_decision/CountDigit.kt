package kiz.learnwithvel.problems.ab_decision

fun main() {

    var count = 0
    var number = 1234567
    while (number != 0) {
        number /= 10
        count++
    }
    println("Number of digits: $count")
}