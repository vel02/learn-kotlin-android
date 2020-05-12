package kiz.learnwithvel.challenge2

import kiz.learnwithvel.challenge2.javacode.JavaCode

fun main(args: Array<String>) {

    // 1. Declare a non-nullable float variable two ways,
    // and assign it the value -3847.384

    val number_one: Float = -3847.384F//verbose
    val number_two = -3847.384F//concise
    val bonus = -3847.384.toFloat()//verbose

    // 2. Now change both of those variable declarations into nullable variables.

    val number_three: Float? = -3847.384F
    val number_four: Float? = -3847.384.toFloat()

    // 3. Now declare an array of type non-nullable Short. Make it size 5,
    // and assign it the values 1, 2, 3, 4, and 5.

    //primitive
    val shortArrays = shortArrayOf(1, 2, 3, 4, 5) //short
    //wrapper                           int[]{1,2,3,4,5}
    val shortArrays2: Array<Short> = arrayOf(1, 2, 3, 4, 5) //long

    // 4. Now declare an array of nullable Ints and initialize it with the values
    // 5, 10, 15, 20, 25, 30, 35, 40, 45, 50., all the way up to 200.

    //concise
    //lambda
    val inArrays = Array<Int?>(40) { i -> (i + 1) * 5 }
    for (i in inArrays.indices)
        print("${inArrays[i]} ")

    // 5. You have to call a Java method with the following signature from Kotlin:
    // public void method (char[] charArray). Declare an array that you could
    // pass to the method and initialize it with the values 'a', 'b', and 'c'.

    println()
    val charArray = charArrayOf('a', 'b', 'c')
    JavaCode.method1(charArray)

    // 6. Given the following code:
    val x: String? = "I AM IN UPPERCASE"
    // Using one line of code, declare another string variable,
    // and assign it x.toLowerCase() when x isn't null,
    // and the string "I give up!" when x is null.
    val str = x?.toLowerCase() ?: "I give up!" // using elvis  to achieved it.

    // 7. Now use the let function to (a) lowercase the string, and then
    // (b) replace "am" with "am not" in the result

    val str2 = x?.let { println(it.toLowerCase().replace("am", "am not")) }

    // 8. You're really, really confident that the variable myNonNullVariable can't
    // contain null.
    // Change the following code to assert that myNonNullVariable isn't null
    // (and shoot yourself in the foot!)
    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()


}