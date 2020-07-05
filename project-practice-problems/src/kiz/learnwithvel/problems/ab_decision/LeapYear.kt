package kiz.learnwithvel.problems.ab_decision

fun main() {

    print("Enter year: ")
    val year = readLine()!!.toInt()

    var leap = if (year % 4 == 0 || year % 100 == 0) {
        (year % 400 == 0)
    } else false

    println(leap)

    leap = when {
        leap -> year % 4 == 0 || year % 100 == 0
        leap -> year % 400 == 0
        else -> false
    }
    println(leap)

}