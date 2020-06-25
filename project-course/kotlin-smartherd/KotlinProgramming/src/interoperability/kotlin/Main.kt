@file:JvmName("MyCustomKotlinFileName")

package interoperability.kotlin

import interoperability.java.Main

fun main(args: Array<String>) {

    var area = Main.getArea(10, 5)
    println("Printing area from Kotlin file: $area")

}

fun add(a: Int, b: Int): Int {
    return a + b
}