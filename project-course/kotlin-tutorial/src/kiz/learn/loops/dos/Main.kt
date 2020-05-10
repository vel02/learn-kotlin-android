package kiz.learn.loops.dos

fun main(args: Array<String>) {

//    for (i in 1..10) {
    val dracula = VampireKing("Dracula")
    println(dracula)
    dracula.lives = 0

    do {
        if (dracula.dodges()) {
            dracula.lives += 1
            continue
        }
        if (dracula.runAway()) {
            println("Dracula ran away")
            break
        } else dracula.takeDamage(12)
    } while (dracula.lives > 0)
    println("==============================")
//    }

//    val vel = Player("Vel")
//    vel.getLoot(Loot("Invisibility", LootType.POTION, 4.0))
//    vel.getLoot(Loot("Mithril", LootType.ARMOR, 183.0))
//    vel.getLoot(Loot("Ring of Speed", LootType.RING, 25.0))
//    vel.getLoot(Loot("Red Potion", LootType.POTION, 2.0))
////    vel.getLoot(Loot("Cursed Shield", LootType.ARMOR, -8.0))
//    vel.getLoot(Loot("Brass Ring", LootType.RING, 1.0))
//    vel.getLoot(Loot("Chain Ring", LootType.RING, 4.0))
//    vel.getLoot(Loot("Gold Ring", LootType.RING, 12.0))
//    vel.getLoot(Loot("Health Potion", LootType.POTION, 3.0))
//    vel.getLoot(Loot("Silver Ring", LootType.RING, 6.0))
//    vel.showInventory()

}