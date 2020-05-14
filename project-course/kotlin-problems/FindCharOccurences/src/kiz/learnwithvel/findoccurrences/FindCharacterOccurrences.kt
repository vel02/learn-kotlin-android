package kiz.learnwithvel.findoccurrences

fun main(args: Array<String>) {

    val str = "This website is awesome"
    val char = 'e'

    var frequency = 0
    for (element in str) {
        if (element == char) frequency++
    }

    println("Number of occurrences of character $char is/are $frequency")
}