package kiz.learnwithvel.numberpower

fun main(args: Array<String>) {

    var nth = 7
    val base = 2
    var power = 1L


    while ((nth--) != 0) {
        power *= base.toLong()
    }
    println(power)
}