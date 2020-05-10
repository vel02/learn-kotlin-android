package kiz.learn.inheritance

class VampireKing(name: String) : Vampire(name) {
    //changes hitPoints value in parent class for this class
    init {
        hitPoints = 140
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }
}