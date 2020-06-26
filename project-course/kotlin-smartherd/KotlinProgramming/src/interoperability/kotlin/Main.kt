@file:JvmName("MyCustomKotlinFileName")

package interoperability.kotlin

import interoperability.java.Main

fun main(args: Array<String>) {

    var area = Main.getArea(10, 5)
    println("Printing area from Kotlin file: $area")

    var result = findVolume(2, 3)
    println(result)

}

@JvmOverloads
fun findVolume(length: Int, breadth: Int, height: Int = 10) = length * breadth * height

fun add(a: Int, b: Int): Int {
    return a + b
}