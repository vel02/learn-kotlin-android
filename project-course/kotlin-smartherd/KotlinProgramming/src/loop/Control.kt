package loop

fun main(args: Array<String>) {

    for (i in 1..10) {
        println(i)
        if (i == 5)
            break
    }

    println()
    //Break
    myLOOP@ for (i in 1..3) {
        for (j in 1..3) {
            println("$i $j")
            if (i == 2 && j == 2)
                break@myLOOP
        }
    }

    //Continue
    println()

    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

    println()

    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2)
                continue@outer
            println("$i $j")
        }

    }

}