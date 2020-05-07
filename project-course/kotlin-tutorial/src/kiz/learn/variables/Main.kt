package kiz.learn.variables

fun main() {
    println("Hello, World")
    println("My first Kotlin program")

    var vel: String
    vel = "Ariel Austria"
    println(vel)

    var velWeeklySalary: Int = 32
    var velMonthlySalary: Int = velWeeklySalary * 4
    println(velWeeklySalary)
    println(velMonthlySalary)

    println()

    val apples: Int = 6
    val oranges: Int = 5
    var fruit: Int = apples - oranges
    println(fruit)

    println(apples / 4)

    println()
    val weeks: Int = 130
    val years: Double = weeks / 52.0
    println(years)


}