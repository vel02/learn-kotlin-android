package kiz.learn.loops

fun main(args: Array<String>) {
//    val vel = Player("Ariel")
//    vel.weapon = Weapon("Sword", 20)
//    println(vel)
//    val chestArmor = Loot("+3 Chest Armor", LootType.ARMOR, 80.00)
//    val redPotion = Loot("Red Potion", LootType.POTION, 7.50)
//    vel.inventory.add(redPotion)
//    vel.inventory.add(chestArmor)
//    vel.inventory.add(Loot("Ring of Protection +2", LootType.RING, 40.25))
//    vel.inventory.add(Loot("Invisibility Potion", LootType.RING, 35.95))
//    vel.showInventory()
//
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

    //loop i in 1 to 10
    //loop i in 0 until 10
    //loop i in 10 downTo 0
    //loop i in 10 downTo 0 step 2
    for (i in 10 downTo 0 step 2) {
        println("$i square is ${i * i}")
    }

    //challenge
    for (i in 3..100) {
        if ((i % 3 == 0) and (i % 5 == 0))
            print("$i ")
    }
    //using step
    println()
    for (i in 3..100 step 3) {
        if (i % 5 == 0)
            print("$i ")
    }


}