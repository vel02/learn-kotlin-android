package kiz.learnwithvel.problems.aa_introduction

fun main() {

    print("Enter a character: ")
    val character = read().toCharArray()[0]

    println("The ASCII code of $character is ${getASCII(character = character)}")

}

private fun read() = readLine()!!

private fun getASCII(character: Char) = character.toInt()