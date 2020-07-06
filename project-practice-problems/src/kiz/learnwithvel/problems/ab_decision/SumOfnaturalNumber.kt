package kiz.learnwithvel.problems.ab_decision


fun main() {

    val number = 4
    var sum = 0

    for (i in 1..number) {
        sum += i
    }
    println("Sum is $sum")

    sum = 0

    val i = 1
    while (i in 1..number) sum += i
    println(sum)

}