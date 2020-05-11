package kiz.learnwithvel.nullreferences

fun main(args: Array<String>) {

//    val str: String? = "This isn't null"
//    str?.toUppercase()

//    //safe operator
//    val str: String? = null//"This isn't null"
//    println("What happens when we do this: ${str?.toUpperCase()}")
//
//    //elvis operator
//    val st2 = str ?: "This is the default value"
//    println("What happens when we do this: ${st2.toUpperCase()}")
//
//    //safe casting
//    val something: Any = arrayOf(1, 2, 3, 4)
//    val str3 = something as? String
//    println(str3)
//    //with elvis operator for default value
//    println(str3?.toUpperCase() ?: "This is the default value")
//
//    //if you know 100% sure that a variable is not null for that specific time
//    //you can tell to the compiler that you are sure by using non-null assertion
//    //you can still use ? safe operator but there are times that you want to
//    //see a null pointer exception so use !!
//    val str4 = str!!.toUpperCase()


    val str: String? = "This isn't null"
    str?.let { printText(it) }

    //== is also safe operator
    val str4 : String? = null
    val anotherStr = "This isn't nullable"
    println(str4 == anotherStr)

    val str2 = str!!
    val str3 = str2.toUpperCase()
}

fun printText(text: String) {
    println(text)
}