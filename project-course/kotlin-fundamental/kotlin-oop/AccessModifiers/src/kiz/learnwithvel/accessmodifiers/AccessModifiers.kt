package kiz.learnwithvel.accessmodifiers

fun main(args: Array<String>) {
    val emp = Employee()
    println(emp)
}

/**
 * This class is visible in everything in the same file. (private)
 * (public) is the default access modifier.
 * (protected) can't be use in the top level.
 * (internal) being visible inside the module.
 *
 * Top-Level Items
 * (private)    Visible within the same file
 * (protected)  Can't be use
 * (public)     Visible everywhere
 * (internal)   Visible within the same module
 *
 * All classes in Kotlin are public and final by default
 */
private class Employee {

}