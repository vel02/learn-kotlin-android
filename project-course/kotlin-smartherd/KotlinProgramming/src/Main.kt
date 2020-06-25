fun main(args: Array<String>) {

    val name = "Sam"
    val str = "Hello $name"
    println("The Statement is $str. The number of characters in statement is ${str.length}")

    val a = 10
    val b = 5
    println("The sum of $a and $b is ${a + b}")

    var rect = Rectangle()
    rect.length = 5
    rect.breadth = 3
    println("The length of rectangle is ${rect.length} and ${rect.breadth} is ${rect.breadth}. " +
            "The Area is ${rect.length * rect.breadth}.")
}


class Rectangle {
    var length: Int = 0
    var breadth: Int = 0


}