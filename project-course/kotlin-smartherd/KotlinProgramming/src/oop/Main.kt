package oop

fun main(args: Array<String>) {

    var student = Student("Yel", 20)

    println("Student has got a name as ${student.name}")


}

//properties, and parameter
class Student(var name: String, age : Int) {

    init {
        println("Student age is $age")
    }
}