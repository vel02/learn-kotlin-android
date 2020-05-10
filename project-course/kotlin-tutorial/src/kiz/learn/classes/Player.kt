package kiz.learn.classes

//primary constructor with default value
class Player(
    private val name: String,
    private var level: Int = 1,
    private var lives: Int = 3,
    private var score: Int = 0
) {
    var weapon: Weapon = Weapon("Fist", 1)

    fun show() {

        println(
            """
            |
            |name: $name
            |lives: $lives
            |level: $level
            |score: $score
            |weapons: 
        """.trimMargin()
        )
    }
}