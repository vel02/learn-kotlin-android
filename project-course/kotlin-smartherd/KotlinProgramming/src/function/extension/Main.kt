package function.extension

fun main(args: Array<String>) {

    val str1 = "Hello "
    val str2 = "World"

    var str3 = "Hey "

    println(str3.add(str1, str2))

    val x = 6
    val y = 10

    val max = x.greaterValue(y)
    println("Max is $max")

}

fun Int.greaterValue(other: Int) = if (this > other) this else other

fun String.add(str1: String, str2: String) = this + str1 + str2
