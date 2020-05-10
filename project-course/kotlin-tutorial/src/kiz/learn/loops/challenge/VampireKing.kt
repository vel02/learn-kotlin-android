package kiz.learn.loops.challenge

import java.util.*

class VampireKing(name: String) : Vampire(name) {
    //changes hitPoints value in parent class for this class
    init {
        hitPoints = 140
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }

    fun runAway(): Boolean {
        return lives < 2
    }

    fun dodges(): Boolean {
        val ran = Random()
        val chance = ran.nextInt(6)
        if (chance > 3) {
            println("Dracula dodges")
            return true
        }
        return false
    }
}