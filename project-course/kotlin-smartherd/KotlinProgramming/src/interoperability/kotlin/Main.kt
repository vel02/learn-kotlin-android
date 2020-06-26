@file:JvmName("MyCustomKotlinFileName")

package interoperability.kotlin


fun main(args: Array<String>) {

    findVolume(length = 2, height = 30, breadth = 3)
    findVolume( breadth = 3, length = 2)

}

fun findVolume(length: Int, breadth: Int, height: Int = 10) {

    println("Length is $length")
    println("Breadth is $breadth")
    println("Height is $height")

}

fun add(a: Int, b: Int): Int {
    return a + b
}