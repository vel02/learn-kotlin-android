package kiz.learnwithvel.problems.ab_decision

fun main() {

    val character = 'i'

    var result = if (character == 'a'
        || character == 'e'
        || character == 'i'
        || character == 'o'
        || character == 'u'
    ) "vowel"
    else "consonant"

    println(result)


    result = when (character) {
        'a', 'e', 'i', 'o', 'u' -> "$character is vowel"
        else -> "$character is consonant"
    }

    println(result)

}