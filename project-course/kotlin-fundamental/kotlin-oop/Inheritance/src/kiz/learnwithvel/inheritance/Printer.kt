package kiz.learnwithvel.inheritance

fun main(args: Array<String>) {

    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()

}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")

    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {

    final override fun printModel() = println("The model name of this laser printer is $modelName")

    override fun bestSellingPrice() = 129.99

}

class SpecialLaserPrinter(modelName: String, ppm: Int) : LaserPrinter(modelName, ppm) {

}

//calling secondary constructor.
//Note: you cannot have primary constructor, it can't call secondary because of delegation
open class Something {

    val someProperty: String

    constructor(someParameter: String) {
        someProperty = someParameter
    }

}

class SomethingElse : Something {

    constructor(someOtherParameter: String) : super(someOtherParameter)

}