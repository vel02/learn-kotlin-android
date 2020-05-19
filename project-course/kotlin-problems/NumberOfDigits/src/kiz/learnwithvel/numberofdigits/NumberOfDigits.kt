package kiz.learnwithvel.numberofdigits


fun main(args: Array<String>) {

    var input = 12345
    var count = 0
    while (input != 0) {
        count++
        input /= 10
    }

    println(count)
}