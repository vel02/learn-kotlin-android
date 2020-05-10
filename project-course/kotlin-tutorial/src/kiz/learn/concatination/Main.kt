package kiz.learn.concatination

fun main() {

    println("Hello, World")
    println("My first Kotlin program")
    val tim: String

    val vel: String
    vel = "Ariel Austria"
    println("My name is $vel")

    val velWeeklySalary: Int = 32
    val velMonthlySalary: Int = velWeeklySalary * 4
    println(velWeeklySalary)
    println("Vel's monthly salary is $$velMonthlySalary")

    println()

    val apples: Int = 6
    val oranges: Int = 5
    val fruit: Int = apples - oranges
    println("Remanding fruits are $fruit")

    //interpolation
    println("A quarter of the apples is ${apples / 4}")

    println()
    val weeks: Int = 130
    val years: Double = weeks / 52.0
    println("$weeks weeks is $years years")

    tim = "Tim Buchalka"

    //concatenation
//    println("(Concatenation) My name is " + vel)
    //interpolation
    println("(Interpolation) My name is $vel")
    println("I can print \$vel")
    println("Tim is $tim")

    /*
        Why var or val?
        val - value
        var - variable
     */

}