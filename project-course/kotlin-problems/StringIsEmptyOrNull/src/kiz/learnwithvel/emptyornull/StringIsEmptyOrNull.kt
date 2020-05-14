package kiz.learnwithvel.emptyornull

fun main(args: Array<String>) {


    val str1: String? = null
    val str2 = ""

    if (isNullOrEmpty(str1))
        println("is null or empty")
    else println("is not null or empty")

    if (isNullOrEmpty(str2))
        println("is empty")
    else println("is not empty")

}

fun isNullOrEmpty(str: String?): Boolean {
    if (str != null && str.trim().isNotEmpty())
        return false
    return true
}