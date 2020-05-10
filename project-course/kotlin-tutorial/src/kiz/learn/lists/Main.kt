package kiz.learn.lists

fun main(args: Array<String>) {

    val vel = Player("Ariel")
    vel.weapon = Weapon("Sword", 20)
    println(vel)
    val redPotion = Loot("Red Potion", LootType.POTION, 7.50)
    vel.inventory.add(redPotion)
    vel.showInventory()

    val louise = Player("louise", 5)
    louise.weapon = vel.weapon
    louise.show()

    val yen = Player("Yen", 4, 8)
    yen.show()

    val ru = Player("Ru", 2, 5, 1000)
    ru.show()


    val axe = Weapon("Axe", 12)
    ru.weapon = axe
    axe.damageInflicted = 24
    ru.show()

    yen.weapon = Weapon("Sword", 10)
    yen.show()

    yen.weapon = Weapon("Spear", 14)
    yen.show()
}