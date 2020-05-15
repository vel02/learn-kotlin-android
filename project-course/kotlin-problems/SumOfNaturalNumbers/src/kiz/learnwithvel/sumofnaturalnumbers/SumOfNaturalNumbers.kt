package kiz.learnwithvel.sumofnaturalnumbers

fun main(args: Array<String>) {

    val num = 100
    var sum = 0
    /*
        n(n + 1)/2
     */

    val noLoop = num * (num + 1) / 2
    println(noLoop)


    for (i in 0..num)
        sum += i

    println(sum)

    sum = 0
    var i = 0
    while (i <= num) {
        sum += i
        i++
    }

    println(sum)
}