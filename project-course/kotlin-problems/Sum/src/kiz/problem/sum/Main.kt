package kiz.problem.sum


fun main(args: Array<String>) {

    /*
        ELEMENTS ARE: 23, 42, 1122, 75 SUM IS ?

     */

    val numbers = intArrayOf(23, 42, 1122, 75)//int[]
    println("Sum is ${sum(numbers)}")
    
}

fun sum(number: IntArray): Int {
    //IntArray expect int[]
    var result = 0
    for (num in number) {
        result += num
    }
    return result
}