package kiz.learn.inheritance

fun main(args: Array<String>) {
    val uglyTroll = Troll("Ugly Troll")
    uglyTroll.takeDamage(30)

    val vampire = Vampire("Vlad")
    vampire.takeDamage(8)

    val dracula = VampireKing("Dracula")
    println(dracula)
    dracula.takeDamage(12)
}