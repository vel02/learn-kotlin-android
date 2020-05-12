package kiz.learnwithvel.accessmodifiers

fun main(args: Array<String>) {
    val emp = Employee("John")
    println(emp.firstName)


    val emp2 = Employee("Joe")
    println(emp2.firstName)
    println(emp2.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.firstName)
    println(emp3.fullTime)

    println(Demo().dummy)
}

/**
 * Short way implementation of secondary constructor with default value
 */
class Employee(val firstName: String, var fullTime: Boolean = true) {

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