package kiz.learnwithvel.problems.aa_introduction

fun main() {

    val str1: String? = null
    val str2 = "  "

    var result = if (isNullOrEmpty(str1)) "st1 is not null or empty"
    else "str1 is null or empty"
    println(result)

    result = if (isNullOrEmpty(str2)) "st1 is not null or empty"
    else "str1 is null or empty"
    println(result)


}

fun isNullOrEmpty(value: String?) = (value != null && value.trim().isNotEmpty())