package kiz.learnwithvel.problems.ab_decision.final

fun main() {


    for (i in 1..5) {

        for (j in (i + 0)..5) {
            print(" ")
        }

        for (k in (5 - i)..4) {
            print("*")
        }

        for (k in (5 - i)..3) {
            print("*")
        }

        println()
    }

}