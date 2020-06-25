package control_statement

fun main(args: Array<String>) {

    // IF as Expression

    val a = 2
    val b = 5

    val maxValue: Int = if (a > b) {
        println("A is greater")
        a
    } else {
        println("B is greater")
        b
    }
    println(maxValue)


    // WHEN as Expression

    val x = 1
    val str: String = when (x) {
        in 1..20 -> "x is lies in 1 to 10"
        2 -> {
            "x is 2"
        }
        else -> {
            "x value is unknown."
        }
    }

    println(str)


}