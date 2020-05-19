package kiz.learnwithvel.lcm


fun main(args: Array<String>) {
    //source: https://www.mathsisfun.com/least-common-multiple.html

    val operand1 = 72
    val operand2 = 120

    var i = 1

    while (true) {
        val lcm = operand1 * i++
        if ((lcm % operand2) == 0) {
            println("The LCM of $operand1 and $operand2 is $lcm.")
            break
        }
    }


}