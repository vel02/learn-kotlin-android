package kiz.learn.classes

fun main(args: Array<String>) {

    val vel = Player("Ariel")
    vel.show()

    val louise = Player("louise", 5)
    louise.show()

    val yen = Player("Yen", 4, 8)
    yen.show()

    val ru = Player("Ru", 2, 5, 1000)
    ru.show()
    println(ru.weapon.name.toUpperCase())
    println(ru.weapon.damageInflicted)

    val axe = Weapon("Axe", 12)
    ru.weapon = axe
    println(ru.weapon.name)
    println(ru.weapon.damageInflicted)

    axe.damageInflicted = 24
    println(axe.damageInflicted)
    println(ru.weapon.damageInflicted)

    yen.weapon = Weapon("Sword", 10)
    println(yen.weapon.name)

    yen.weapon = Weapon("Spear", 14)
    println(yen.weapon.name)
}