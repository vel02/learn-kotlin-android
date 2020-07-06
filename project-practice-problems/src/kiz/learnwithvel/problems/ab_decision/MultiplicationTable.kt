package kiz.learnwithvel.problems.ab_decision

fun main() {

    val number = 2

    var product: Int
    for (i in 1..10) {
        product = (i * number)
        println("$i * $number = $product")
    }

    var i = 1
    while (i in 1..10) {
        product = (i * number)
        println("$i * $number = $product")
        i++
    }

}