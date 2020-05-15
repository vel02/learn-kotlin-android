package kiz.learnwithvel.table

fun main(args: Array<String>) {

    val number = 6

    for (i in 1..10) {
        val ans = number * i
        println("$number * $i = $ans")
    }

    var i = 1
    while (i <= 10) {
        val ans = number * i
        println("$number * $i = $ans")
        i++
    }
}
