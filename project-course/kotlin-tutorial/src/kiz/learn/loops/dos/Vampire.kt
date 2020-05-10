package kiz.learn.loops.dos

open class Vampire(name: String) : Enemy(name, 20, 3) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)// vampire take half damage
    }
}