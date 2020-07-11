package kiz.learnwithvel.problems.ab_decision.final

fun main() {

    for (i in 1..5) {
        for (j in (5 - i)..4) {
            print(" ")
        }
        for (k in (0 + i)..5) {
            print("*")
        }
        for (k in (1 + i)..5) {
            print("*")
        }
        println()
    }

    for (i in 1..5) {

        println()
    }


}