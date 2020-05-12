package kiz.learnwithvel.classesimplementation.kotlincode

import java.text.NumberFormat
import java.util.*

fun main(args: Array<String>) {

    //kotlin
    val emp = Employee("Ariel Namias Austria", "Software Developer", 100_000.00)
    println(emp.mFullName)
    println(emp.mDepartment)
    println(NumberFormat.getCurrencyInstance(Locale.US).format(emp.mSalary))
    println(emp.mWorkedAt)


    //javacode
    val emp2 = kiz.learnwithvel.classesimplementation.javacode.Employee(
        "Ariel Namias Austria",
        "Software Developer",
        100_000.00
    )
    println(emp2.fullName)
    println(emp2.department)
    println(NumberFormat.getCurrencyInstance(Locale.US).format(emp2.salary))
    println(emp2.workedAt)


}

class Employee(
    val mFullName: String,
    val mDepartment: String,
    val mSalary: Double,
    val mWorkedAt: String = "Learn with Vel Inc."
) {


}