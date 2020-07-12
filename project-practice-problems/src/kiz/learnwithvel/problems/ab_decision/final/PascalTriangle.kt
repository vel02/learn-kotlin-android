package kiz.learnwithvel.problems.ab_decision.final

fun main() {


    val rows = 6
    var coef = 1

    for (i in 0 until rows) {

        for (space in 1 until rows - i) {
            print("  ")
        }

        for (j in 0..i) {
            coef = if (j == 0 || i == 0) {
                1
            } else coef * (i - j + 1) / j

            System.out.printf("%4d", coef)
        }
        println()

    }

}