package loop

fun main(args: Array<String>) {

    // LOOPS in Kotlin

    // For

    for (i in 1..10) {
        if (i % 2 == 0)
            println(i)
    }

    println()

    // WHILE
    var i = 1
    while (i <= 10) {
        if (i % 2 == 0)
            println(i)
        i++
    }

    println()

    // DO  WHILE
    i = 1
    do {
        if (i % 2 == 0)
            println(i)
        i++
    } while (i <= 10)


}