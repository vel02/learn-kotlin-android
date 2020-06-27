package oop.inheritance

fun main(args: Array<String>) {

    val dog = Dog()
    dog.bread = "labra"
    dog.color = "black"
    dog.bark()
    dog.eat()

    val cat = Cat()
    cat.age = 20
    cat.color = "white"
    cat.meow()
    cat.eat()

    val animal = Animal()
    animal.color = "Pink"
    animal.eat()

}

open class Animal {
    var color: String = ""

    fun eat() {
        println("eat")
    }
}

class Dog : Animal() {

    var bread: String = ""

    fun bark() {
        println("bark")
    }


}

class Cat : Animal() {

    var age: Int = -1

    fun meow() {
        println("meow")
    }


}

