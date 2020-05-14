package kiz.learnwithvel.removewhitespaces

fun main(args: Array<String>) {

    var str = "T    his is b  ett     er."
    println("Original sentence: $str")
    str = str.replace("\\s".toRegex(), "")
    println("After replacement: $str")

}