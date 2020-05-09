package kiz.learnprogramming.declarations

//Type Alias
typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    //var - mutable vs val - immutable or final
    var number: Int
    number = 10
    number = 21

    val employee = Employee("Lynn Jones", 500)
    employee.name = "Lynn Smith"
//    employee = Employee("Tim Watson", 100) not allowed in immutable declaration

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    } else {
        employee2 = Employee("Mike Watson", 150)
    }

//    number = "hello" cannot change the variable type


    //typealias
    val employees: EmployeeSet


    //collection
    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])


    //String
    println(employee)

    val change = 4.22
    println("\$$change")

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator / denominator}")

    val filePath = """c:\somdir\somedir2"""
    val eggName = "Humpty"
    val nurseryRhyme = """$eggName Dumpty sat on the wall
        |$eggName Dumpy had a great fall
    """.trimMargin("|")
    println(nurseryRhyme)


}

class Employee(var name: String, val id: Int) {

    override fun toString(): String {
        return "Employee(name=$name, id=$id)"
    }
}