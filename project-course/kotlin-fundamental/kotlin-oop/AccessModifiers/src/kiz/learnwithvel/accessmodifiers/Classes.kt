package kiz.learnwithvel.accessmodifiers

//constants
const val MY_CONSTANT = 100

fun main(args: Array<String>) {

    println(MY_CONSTANT)

    //using data class
    val car = Car("Blue", "Toyota", 2015)
    println(car)
    val car2 = Car("Blue", "Toyota", 2015)
    println(car == car2)
    val car3 = car.copy()//reference copied
    println(car3)
    val car4 = car.copy(year = 2016)//copy except year
    println(car4)


    //using regular class
    val emp = Employee("Ariel", false)
    println(emp)
    val emp2 = Employee("Ariel", false)
    println(emp == emp2)//not implemented equals

//    val emp = Employee("John")
//    println(emp.firstName)
//    emp.fullTime = false
//    println(emp.fullTime)
//
//
//    val emp2 = Employee("Joe")
//    println(emp2.firstName)
//    println(emp2.fullTime)
//
//    val emp3 = Employee("Jane", false)
//    println(emp3.firstName)
//    println(emp3.fullTime)
//
//    println(Demo().dummy)
}

//data class or model
data class Car(val color: String, val model: String, val year: Int) {
    //get extra functionality, like toString(), a custom implementation of
    //equals and hashcode, and a copy function
    //can't be abstract, sealed or inner classes
}

/**
 * Short way implementation of secondary constructor with default value
 */
class Employee(val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }

}


/**
 * Long way implementation of secondary constructor without primary but with default value
 */
class Demo {

    val dummy: String

    constructor() {
        this.dummy = "hello"
    }
}