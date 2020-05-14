package kiz.learnwithvel.leapyear

fun main(args: Array<String>) {

    print("Enter year: ")
    val year = readLine()!!.toInt()

    val javaWay = JavaWay()
    val isLeapYear = javaWay.isLeapYear(year)
    println(if (isLeapYear) "$year is leap year" else "$year not leap year")

    usingWhenExpression(year)
    usingIfExpression(year)
}

fun usingWhenExpression(year: Int) {
    val isLeapYear = when {
        ((year % 4 == 0) and (year % 100 != 0) or (year % 400 == 0)) -> true
        else -> false
    }

    println(if (isLeapYear) "$year is leap year" else "$year not leap year")
}

fun usingIfExpression(year: Int) {
    val isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)
    println(if (isLeapYear) "$year is leap year" else "$year not leap year")
}