package kiz.learnwithvel.inheritance


fun main(args: Array<String>) {

    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()

}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")

}

class LaserPrinter(modelName: String) : Printer(modelName) {

    override fun printModel() = println("The model name of this laser printer is $modelName")

}