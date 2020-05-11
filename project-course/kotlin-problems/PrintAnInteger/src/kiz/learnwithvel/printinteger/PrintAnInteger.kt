package kiz.learnwithvel.printinteger

import java.lang.System.`in`
import java.util.*

fun main(args: Array<String>) {


    //Print an Integer entered by an user in Kotlin using Scanner

    mySolution()
    solutionOne()
    solutionTwo()
}

fun mySolution() {
    print("Enter an integer: ")
    try {
        //readLine() is not nullable (!!)
        val userInput = readLine()!!.toInt()
        println("The input is $userInput")
    } catch (e: NumberFormatException) {
        println("Invalid Input")
    }
}

fun solutionOne() {

    val reader = Scanner(`in`)
    print("Enter an integer: ")
    val userInput = reader.nextInt()
    println(userInput)

}


fun solutionTwo() {
    print("Enter a number: ")

    // reads line from standard input - keyboard
    // and !! operator ensures the input is not null
    val stringInput = readLine()!!

    // converts the string input to integer
    val integer: Int = stringInput.toInt()

    // println() prints the following line to the output screen
    println("You entered: $integer")
}