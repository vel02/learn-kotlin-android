package function.infix

fun main(args: Array<String>) {

    val x = 6
    val y = 10


    val max = x greaterValue y // benefit of infix : x.greaterValue(y)
    println("Max is $max")

}

//Infix function and also Extension function
infix fun Int.greaterValue(other: Int) = if (this > other) this else other //infix can only have one parameter
