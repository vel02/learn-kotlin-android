package kiz.problem.indexofsum

fun main(args: Array<String>) {

    val number = intArrayOf(12, 34, 66, 23)
    println("The largest value can be found in index ${indexOfMax(number)}")
}

fun indexOfMax(a: IntArray): Int? {

    var withMaxElement = 0
    var maxElement = 0
    for (number in a) {
        if (number > maxElement) {
            maxElement = number
            withMaxElement = a.indexOf(number)
        }
    }
    return withMaxElement
}
