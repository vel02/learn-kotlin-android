package oop

fun main(args: Array<String>) {

    var student = Student("Yel")

    println("Student has got a name as ${student.name}")


}

//properties, and parameter
class Student(var name: String) {
    init {
        //this can be used as a primary constructor's body
        println("Student age is $name")
    }

    //secondary constructor
    constructor(name: String, id: Int) : this(name) {
        //body
    }
}