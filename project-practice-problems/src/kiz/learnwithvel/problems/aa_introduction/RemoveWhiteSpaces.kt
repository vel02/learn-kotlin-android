package kiz.learnwithvel.problems.aa_introduction

fun main() {

    var str = "T his is  b ett    er"

    str = str.replace("\\s".toRegex(), "")
    println(str)

}