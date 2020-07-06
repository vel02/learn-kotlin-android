package kiz.learnwithvel.problems.ab_decision

fun main() {

    val number = 10
    var factorial = 1
    for (i in 1..number) factorial *= i
    println(factorial)

    factorial = 1

    var i = 1
    while (i in 1..number) {
        factorial *= i
        i++
    }
    println(factorial)

}