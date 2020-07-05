package kiz.learnwithvel.problems.ab_decision

fun main() {

    print("Enter a character: ")
    val input = readLine()!!.toCharArray()[0]

    var isCharacter = if (input in 'a'..'z' || input in 'A'..'Z')
        "input is a character"
    else "input is not a character"
    println(isCharacter)

    isCharacter = when (input) {
        in 'a'..'z', in 'A'..'Z' -> "input is a character"
        else -> "input is not a character"
    }
    println(isCharacter)

}