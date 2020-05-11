package kiz.learnwithvel.mtfpn

fun main(args: Array<String>) {

    mySolution()
    solution()
}

fun mySolution() {
    try {
        print("Enter first floating point number: ")
        val firstInput = readLine()!!.toFloat()
        print("Enter second floating point number: ")
        val secondInput = readLine()!!.toFloat()

        println("The product of $firstInput by $secondInput is ${firstInput * secondInput}")
    } catch (e: NumberFormatException) {
        println("Invalid Input")
    }
}

fun solution() {
    val first = 1.5f
    val second = 2.0f

    val product = first * second

    println("The product is: $product")
}