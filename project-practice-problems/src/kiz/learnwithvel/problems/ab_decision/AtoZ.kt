package kiz.learnwithvel.problems.ab_decision

fun main() {

    var i: Int = 'a'.toInt()
    while (i <= 'z'.toInt()) {
        print("${i++.toChar().toUpperCase()} ")
    }

    println()

    var character = 'A'
    while (character <= 'Z') {
        print("${character++.toLowerCase()} ")
    }

}