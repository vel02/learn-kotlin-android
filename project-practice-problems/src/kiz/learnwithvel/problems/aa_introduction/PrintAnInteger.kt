package kiz.learnwithvel.problems.aa_introduction

fun main(args: Array<String>) {

    withoutUsingScanner()
}

private fun read() = readLine()!!

fun withoutUsingScanner() {

    print("Enter an integer number: ")

    val integer = read().toInt()
    println("Integer is $integer")

}