package oop

fun main(args: Array<String>) {

    var student = Student("Yel")

    println("Student has got a name as ${student.name}")


}

class Student(var name: String) {

    init {
        println("Student has got a name as $name")
    }
}