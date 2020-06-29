package dataclasses

fun main(args: Array<String>) {

    val user1 = User("Sam", 10)
    val user2 = User("Sam", 10)

    println(user1.toString())

    if (user1 == user2)
        println("equal")
    else println("not equal")

    val newUser = user1.copy(name = "Peter")
    println(newUser)

}

data class User(var name: String, var id: Int)