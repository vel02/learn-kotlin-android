package kiz.learnwithvel.findascii

fun main(args: Array<String>) {

    mySolution()
    solution()

}

fun mySolution() {
    /*
        String input converted to char then converted to int
     */
    print("Enter a character: ")
    val userInput = readLine()!!.toCharArray()[0]
    val converted = userInput.toInt()
    println("A character $userInput in ASCII is $converted")
}

fun solution() {
    val c = 'a'
    val ascii = c.toInt()

    println("The ASCII value of $c is: $ascii")
}