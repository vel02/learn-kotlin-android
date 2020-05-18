package kiz.learnwithvel.functions

fun main(args: Array<String>) {

    //named arguments
    println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))

    val emp = Employee("Jane")
    println(emp.upperCaseFirstName())


    //varargs
    val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "Ford", 2016)
    val car3 = Car("grey", "Ford", 2017)
    printColors(car1, car2, car3, str = "Color: ")

    //arrayOf uses varargs
    val numbers = arrayOf(1, 2, 3)

    val manyCars = arrayOf(car1, car2, car3)

}

fun printColors(vararg cars: Car, str: String) {
    for (car in cars) {
        println("$str ${car.color}")
    }
}

fun whatever() = 3 * 4

//expression function returning a string
fun labelMultiply(
    operand1: Int, operand2: Int,
    label: String = "The answer is:"
) = ("$label ${operand1 * operand2}")


class Employee(val firstName: String) {
    fun upperCaseFirstName() = firstName.toUpperCase()
}

data class Car(val color: String, val model: String, val year: Int)