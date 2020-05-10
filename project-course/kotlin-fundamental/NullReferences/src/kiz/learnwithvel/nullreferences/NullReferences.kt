package kiz.learnwithvel.nullreferences

fun main(args: Array<String>) {

//    val str: String? = "This isn't null"
//    str?.toUppercase()

    //safe operator
    val str: String? = null
    println("What happens when we do this: ${str?.toUpperCase()}")

    //elvis operator
    val st2 = str ?: "This is the default value"
    println("What happens when we do this: ${st2.toUpperCase()}")

    //safe casting
    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String
    println(str3)
    //with elvis operator for default value
    println(str3?.toUpperCase() ?: "This is the default value")

}