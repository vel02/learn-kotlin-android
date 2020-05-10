package kiz.learn.conditions

fun main(args: Array<String>) {
//    val lives = 0
//
//    var isGameOver = (lives < 1)
//    println(isGameOver)
//
//    if (isGameOver) {
//        println("Game Over!")
//    } else {
//        println("You're still alive!")
//    }

    print("How old are you? ")
    val age = readLine()!!.toInt()
    println("Age is $age")

    val message: String
//    message = if (age < 18) {
//        "You're too young to vote"
//    } else if (age == 100)
//        "Congratulations"
//    else
//        "You can vote"

    message = when {
        age < 18 -> "You're too young to vote"
        age == 100 -> "Congratulations"
        else -> "You can vote"
    }

    println(message)
}