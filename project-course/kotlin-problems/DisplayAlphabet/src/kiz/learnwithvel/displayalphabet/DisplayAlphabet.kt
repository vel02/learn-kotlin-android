package kiz.learnwithvel.displayalphabet

fun main(args: Array<String>) {

    var firstLetter = 'A'.toInt()

    while (firstLetter <= 'Z'.toInt()) {
        print("${firstLetter++.toChar()} ")
    }

}