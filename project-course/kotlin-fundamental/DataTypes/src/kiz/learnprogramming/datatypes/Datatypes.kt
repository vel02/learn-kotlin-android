package kiz.learnprogramming.datatypes

import kiz.learnprogramming.javacode.DummyClass

fun main(args: Array<String>) {

    val myInt = 10
    println("default datatype is ${myInt is Int}")
    var myLong = 22L
    myLong = myInt.toLong()

    val myByte: Byte = 111
    var myShort = myByte.toShort()

    var myDouble = 65.987
    println(myDouble is Double)

    val myFloat = 897.097f
    println("This is a float ${myFloat is Float}")

    myDouble = myFloat.toDouble()

    var char = 'b'
    val myCharInt = 65
    char = myCharInt.toChar()
    println(char)

    val myBoolean = true
    println(myBoolean)

    val vacationTime = false
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println(onVacation)

    //Any class ang Unit class
    val anything : Any
    //Unit - void
}