package kiz.learnwithvel.evenorodd


fun main(args: Array<String>) {

    val output: String?

    print("Enter a number: ")
    val input = readLine()!!.toInt()

    output = if (input % 2 == 0) "even."
    else "odd."

    println("$input is $output")

}
