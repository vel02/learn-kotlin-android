package kiz.learn.lists

//primary constructor with default value
class Player(
    private val name: String,
    private var level: Int = 1,
    private var lives: Int = 3,
    private var score: Int = 0
) {
    var weapon: Weapon = Weapon("Fist", 1)
    val inventory = ArrayList<Loot>()

    fun show() {
        if (lives > 0)
            println("$name is alive")
        else
            println("$name is dead")
    }

    override fun toString(): String {
        return """
            |
            |name: $name
            |lives: $lives
            |level: $level
            |score: $score
            |weapon: $weapon
        """.trimMargin()
    }

    fun showInventory() {
        println("$name's Inventory")
        println(inventory.get(0))
        println("=========================")
    }
}