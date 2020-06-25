package function.expression

fun main(args: Array<String>) {

    //FUNCTION EXPRESSION
    val largerValue = max(4, 6)
    println("The greater number is $largerValue")

}

fun max(a: Int, b: Int) = if (a > b) {
    println("$a is greater")
    a
} else {
    println("$b is greater")
    b
}
