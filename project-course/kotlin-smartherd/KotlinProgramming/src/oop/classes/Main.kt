package oop.classes

fun main(args: Array<String>) {

    var student = Student("Yel", 20)

    println("Student has got a name as ${student.name}")

    println(student.id)

}

//properties, and parameter
class Student(var name: String) {

    //initial value for id parameter, the property of secondary constructor
    var id: Int = -1


    init {
        //this can be used as a primary constructor's body
        println("Student age is $name and id is $id")
    }

    //secondary constructor
    constructor(name: String, id: Int) : this(name) {
        //the body of the secondary constructor is called after the init block
        this.id = id
    }
}