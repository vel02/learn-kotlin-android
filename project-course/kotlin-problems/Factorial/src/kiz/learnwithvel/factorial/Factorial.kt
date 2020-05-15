package kiz.learnwithvel.factorial

fun main(args: Array<String>) {

    val num = 5
    var factorial = 1

    for (i in num downTo 1) {
        factorial *= i
    }

    println(factorial)

    factorial = 1
    var i = num
    while (i >= 1) {
        factorial *= i
        i--
    }
    println(factorial)


}