package kiz.learnwithvel.compute

fun main(args: Array<String>) {
    //quotient = dividend / divisor
    //remainder = dividend % divisor

    print("Enter dividend: ")
    val dividend = readLine()!!.toInt()
    print("Enter divisor: ")
    val divisor = readLine()!!.toInt()

    val quotient: Double = (dividend / divisor).toDouble()
    val remainder = dividend % divisor

    println("$dividend divided to $divisor is equal to $quotient")
    println("$dividend modulo to $divisor is equal to $remainder")

}