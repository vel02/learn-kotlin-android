package kiz.learn.encapsulation

fun main(args: Array<String>) {
    val vel = Player("Ariel")
    vel.weapon = Weapon("Sword", 20)
    println(vel)
    val chestArmor = Loot("+3 Chest Armor", LootType.ARMOR, 80.00)
    val redPotion = Loot("Red Potion", LootType.POTION, 7.50)
    vel.getLoot(redPotion)
    vel.getLoot(chestArmor)
    vel.getLoot(Loot("Ring of Protection +2", LootType.RING, 40.25))
    vel.getLoot(Loot("Invisibility Potion", LootType.RING, 35.95))
    vel.showInventory()
    if (vel.dropLoot(redPotion)) {
        vel.showInventory()
    } else {
        println("You don't have a ${redPotion.name}")
    }

    val bluePotion = Loot("Blue Potion", LootType.POTION, 6.00)
    if (vel.dropLoot(bluePotion)) {
        vel.showInventory()
    } else {
        println("You don't have a ${bluePotion.name}")
    }

//    val louise = Player("louise", 5)
//    louise.weapon = vel.weapon
//    louise.show()
//
//    val yen = Player("Yen", 4, 8)
//    yen.show()
//
//    val ru = Player("Ru", 2, 5, 1000)
//    ru.show()
//    val axe = Weapon("Axe", 12)
//    ru.weapon = axe
//    axe.damageInflicted = 24
//    ru.show()
//
//    yen.weapon = Weapon("Sword", 10)
//    yen.show()
//
//    yen.weapon = Weapon("Spear", 14)
//    yen.show()
}