package kiz.learnwithvel.problems.ab_decision

fun main() {

    val number = 60

    for (i in 1..number) {
        if (number % i == 0) {
            print("$i ")
        }
    }

}