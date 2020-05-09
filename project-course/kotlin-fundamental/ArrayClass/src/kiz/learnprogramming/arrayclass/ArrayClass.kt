package kiz.learnprogramming.arrayclass

import kiz.learnprogramming.arrayclass.javacode.DummyClass
import java.math.BigDecimal

fun main(args: Array<String>) {

    val names = arrayOf("John", "Jane", "Joe")
    val longs = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf(1, 2, 3, 4)

    println(longs is Array<Long>)
    println(longs2 is Array<Int>)

    println(longs[2])

    //lambda
    val evenNumbers = Array(16) { i -> i * 2 }
    for (number in evenNumbers)
        println(number)

    val lotsOfNumbers = Array(100000) { i -> i + 1 }
    for (number in lotsOfNumbers)
        print(number)

    println()

    val allZeroes = Array(100) { i -> 0 }
    for (number in allZeroes)
        print(number)

    println()
    var someArray: Array<Int>
    someArray = arrayOf(1, 2, 3, 4)
    for (number in someArray)
        print(number)


    println()
    someArray = Array(6) { i -> (i + 1) * 10 }
    for (number in someArray)
        print("$number ")

    println()
    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    for (element in mixedArray)
        println(element)

    println(mixedArray is Array<*>)//Any

    val myIntArray = intArrayOf(3, 4, 6, 7, 8, 2)
    DummyClass().printNumbers(myIntArray)

//    var someOtherArray = Array<Int>(5)
//    var array1: Array<Int>
    var someOtherArray = IntArray(5)
    for (number in someOtherArray)
        println(number)


    //convert class to primitive
    DummyClass().printNumbers(evenNumbers.toIntArray())

    //convert primitive to class
    val convertedIntArray: Array<Int> = myIntArray.toTypedArray()


}

