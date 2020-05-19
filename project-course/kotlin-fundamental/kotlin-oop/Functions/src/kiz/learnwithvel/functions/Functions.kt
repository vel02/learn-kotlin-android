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
    printColors(car1, car2, car3)

    //arrayOf uses varargs
    val numbers = arrayOf(1, 2, 3)

    //spread operator to unpacked the array for vararg
    val manyCars = arrayOf(car1, car2, car3)
    printColors(*manyCars)

    //spread operator for unpacking arrays
    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
    for (c in lotsOfCars) {
        println(c)
    }

    //extension function example
    val str = "this is all in lowercase"
    println(str.upperFirstAndLast())//str object calling custom function

}

//extension function(extend or added your custom method to the String class)
// String is the type, str is the object
fun String.upperFirstAndLast(): String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
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