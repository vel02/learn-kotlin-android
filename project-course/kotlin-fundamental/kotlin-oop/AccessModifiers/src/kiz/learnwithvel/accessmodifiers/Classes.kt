package kiz.learnwithvel.accessmodifiers

fun main(args: Array<String>) {
    val emp = Employee("John")
    println(emp.firstName)


    val emp2 = Employee("Joe")
    println(emp.firstName)
    println(emp.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.firstName)
    println(emp3.fullTime)
}

/**
 * Long way implementation of secondary constructor
 */
class Employee(val firstName: String) {

    var fullTime: Boolean = true

    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }

}