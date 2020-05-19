package kiz.learnwithvel.reversenumber

fun main(args: Array<String>) {

    var input = 1234
    var reverse = 0
    while (input != 0) {
        reverse = (reverse * 10) + (input % 10)
        input /= 10
    }
    println("Reverse: $reverse")

}