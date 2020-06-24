package kiz.learnwithvel.primenumber

fun main(args: Array<String>) {

    val input = 30
    var isComposite = false
    var output = ""
    for (i in 2..(input / 2)) {
        isComposite = ((input % i == 0))
        if (isComposite) break
    }

    output = if (isComposite) {
        "$input is composite number"
    } else "$input is prime number"

    println(output)

}