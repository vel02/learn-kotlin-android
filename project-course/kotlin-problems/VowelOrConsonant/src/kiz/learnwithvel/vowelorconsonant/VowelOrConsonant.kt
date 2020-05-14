package kiz.learnwithvel.vowelorconsonant

fun main(args: Array<String>) {

    print("Enter a single character: ")
    val ch = readLine()!!.toCharArray()[0]
    usingIfExpression(ch)
    usingWhenExpression(ch)
}


fun usingWhenExpression(ch: Char) {
    val output = when (ch) {
        'a', 'e', 'i', 'o', 'u' -> "is a vowel"
        else -> "is consonant"
    }
    println("WHEN Expression: $ch $output")
}

fun usingIfExpression(ch: Char) {
    val output = if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        "is a vowel" else "is consonant"

    println("IF Expression: $ch $output")

}