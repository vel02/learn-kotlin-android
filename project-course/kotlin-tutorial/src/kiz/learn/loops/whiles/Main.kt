package kiz.learn.loops.whiles

fun main(args: Array<String>) {
    val uglyTroll = Troll("Ugly Troll")
    uglyTroll.takeDamage(30)

    val vampire = Vampire("Vlad")
    vampire.takeDamage(8)

    val dracula = VampireKing("Dracula")
    println(dracula)
    while (dracula.lives > 0) {
        if (dracula.dodges()) continue
        if (dracula.runAway()) {
            println("Dracula ran away")
            break
        } else dracula.takeDamage(12)
    }
}