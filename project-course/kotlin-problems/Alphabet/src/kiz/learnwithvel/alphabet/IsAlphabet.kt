package kiz.learnwithvel.alphabet

fun main(args: Array<String>) {

    val c = '*'

    if (c.isLetter()) {
        println("$c is an alphabet")
    } else println("$c not an alphabet")

    var isAlphabet = when {
        c.isLetter() -> true
        else -> false
    }

    println(if (isAlphabet) "$c is an Alphabet" else "$c not an Alphabet")

    isAlphabet = when {
        c in 'a'..'z' && c in 'A'..'Z' -> true
        else -> false
    }

    println(if (isAlphabet) "$c is an Alphabet" else "$c not an Alphabet")


}