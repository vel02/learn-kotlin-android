package kiz.learnwithvel.accessmodifiers

fun main(args: Array<String>) {
    val emp = Employee("John")
    println(emp.firstName)
}

/**
 * All classes in Kotlin are public and final by default
 * Compare implementation to javacode to see the difference
 * of writing a class.
 * Using primary constructor.
 *
 * Simplified Implementation
 */
class Employee(val firstName: String) {

}