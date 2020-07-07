package kiz.learnwithvel.problems.ab_decision

/**
 * Euclidean Algorithm
 * https://www.youtube.com/watch?v=p5gn2hj51hs
 * https://stackoverflow.com/questions/3154454/what-is-the-most-efficient-way-to-calculate-the-least-common-multiple-of-two-int
 */
fun main() {


    print("Enter first number: ")
    var a = readLine()!!.toInt()
    print("Enter second number: ")
    var b = readLine()!!.toInt()

    if (a > b) {
        a += b
        b = a - b
        a -= b
    }

    //a = d (q) + r
    var remainder = (b % a)
    var result = b
    val lcm = a * b
    var gcd = 0
    while (remainder != 0) {

        val quotient = (result / remainder)
        (a * quotient) + remainder
        println("$result = $a ($quotient) + $remainder")
        result = a
        a = remainder
        gcd = remainder
        if (result % remainder == 0) break
        remainder = (result % remainder)
    }
    println("GCD is $gcd")
    println("LCM is ${lcm / gcd}")

}
