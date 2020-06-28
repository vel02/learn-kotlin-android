package abstract

fun main(args: Array<String>) {

    val person = Indian()

}

abstract class Person() {       // You cannot create instance of abstract class

    abstract val name: String

    abstract fun eat()          // abstract properties are "open" by default

    open fun getHeight() {}     // A "open" function ready to be overridden
    fun goToSchool() {          // A Normal Function: public and final by default

    }
}

class Indian : Person() {       // SUB Class or DERIVED Class

    override val name: String = "dummy_indian_name"

    override fun eat() {}
    override fun getHeight() {}

}