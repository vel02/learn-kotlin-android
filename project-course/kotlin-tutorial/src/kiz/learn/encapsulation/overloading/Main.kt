package kiz.learn.encapsulation.overloading

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

    if (vel.dropLoot("Invisibility Potion")) {
        vel.showInventory()
    } else {
        println("You don't have an Invisibility Potion")
    }
}