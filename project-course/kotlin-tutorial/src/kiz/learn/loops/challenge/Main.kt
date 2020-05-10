package kiz.learn.loops.challenge

fun main(args: Array<String>) {

    val vel = Player("Vel")
    vel.getLoot(Loot("Invisibility", LootType.POTION, 4.0))
    vel.getLoot(Loot("Mithril", LootType.ARMOR, 183.0))
    vel.getLoot(Loot("Ring of Speed", LootType.RING, 25.0))
    vel.getLoot(Loot("Red Potion", LootType.POTION, 2.0))
//    vel.getLoot(Loot("Cursed Shield", LootType.ARMOR, -8.0))
    vel.getLoot(Loot("Brass Ring", LootType.RING, 1.0))
    vel.getLoot(Loot("Chain Ring", LootType.RING, 4.0))
    vel.getLoot(Loot("Gold Ring", LootType.RING, 12.0))
    vel.getLoot(Loot("Gold Ring", LootType.RING, 12.0))
    vel.getLoot(Loot("Gold Ring", LootType.RING, 12.0))
    vel.getLoot(Loot("Health Potion", LootType.POTION, 3.0))
    vel.getLoot(Loot("Silver Ring", LootType.RING, 6.0))
    vel.getLoot(Loot("Silver Ring", LootType.RING, 6.0))
    vel.showInventory()

    vel.dropLoot("Gold Ring")
    vel.showInventory()

    vel.dropLoot("Silver Ring")
    vel.showInventory()

    val dropped = vel.dropLoot("Something not present")
    println(dropped)
    println(vel.dropLoot("Something else"))
    if (vel.dropLoot("A bit of junk"))
        println("junk dropped")
    else println("You don't have any junk")

}