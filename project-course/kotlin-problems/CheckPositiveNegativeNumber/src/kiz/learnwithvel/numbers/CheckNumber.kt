package kiz.learnwithvel.numbers

fun main(args: Array<String>) {

    val number = 12.3

    usingIfExpression(number)
    usingWhenExpression(number)

}

fun usingWhenExpression(number: Double) {

    val output = when {
        number > 0 -> "positive"
        number < 0 -> "negative"
        else -> "zero"
    }

    println("$number is $output")
}

fun usingIfExpression(number: Double) {
    val output = if (number > 0.0) "positive"
    else if (number < 0.0) "negative"
    else "zero"

    println("$number is $output")
}