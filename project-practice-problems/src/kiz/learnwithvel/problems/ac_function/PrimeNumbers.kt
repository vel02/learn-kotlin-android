package kiz.learnwithvel.problems.ac_function

fun main() {

    val start = 20
    val end = 50

    for (i in start..end) {
        if (isPrime(i)) {
            print("$i ")
        }
    }

}

fun isPrime(number: Int): Boolean {
    for (i in 2..(number / 2)) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}