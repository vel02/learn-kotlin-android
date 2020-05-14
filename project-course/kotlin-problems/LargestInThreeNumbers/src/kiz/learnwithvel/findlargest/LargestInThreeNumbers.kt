package kiz.learnwithvel.findlargest

fun main(args: Array<String>) {

    usingIfExpression()
    usingWhenExpression()
}

fun usingWhenExpression() {
    val n1 = -4.5
    val n2 = 3.9
    val n3 = 2.5

    val largest = when {
        n1 > n2 && n1 > n3 -> n1
        n2 > n1 && n2 > n3 -> n2
        else -> n3
    }

    println("WHEN Expression: $largest is the largest number.")
}

fun usingIfExpression() {
    val n1 = -4.5
    val n2 = 3.9
    val n3 = 2.5

    val largest = if (n1 > n2 && n1 > n3) n1
    else if (n2 > n1 && n2 > n3) n2
    else n3

    println("IF Expression: $largest is the largest number")

}