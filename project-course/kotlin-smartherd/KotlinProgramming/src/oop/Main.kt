package oop

fun main(args: Array<String>) {

    var student = Student("Yel")

    println("Student has got a name as ${student.name}")


}

//properties, and parameter
class Student(var name: String, age : String) {

    init {
        println("Student age is $age")
    }
}