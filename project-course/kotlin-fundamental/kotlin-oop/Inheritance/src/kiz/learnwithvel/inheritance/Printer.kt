package kiz.learnwithvel.inheritance

//override also means open

fun main(args: Array<String>) {

    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()

}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")

    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String) : Printer(modelName) {

    //final, and cannot be overridden by any subclasses of LaserPrinter
    final override fun printModel() = println("The model name of this laser printer is $modelName")

    override fun bestSellingPrice() = 129.99

}

class SpecialLaserPrinter(modelName: String) : LaserPrinter(modelName) {

    //explicitly using final keyword on methods can avoid overriding
    //override fun printModel() = println("This is my way of doing it!!!")

}