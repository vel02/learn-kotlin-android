fun main(args: Array<String>) {


    val rangeOne = 1..5 // ranges 1 to 5


    val rangeTwo = 5 downTo 1 // ranges 5 to 1

    val rangesThree = 5 downTo 1 step 2 // ranges 5 to 1 but step 2 = 5, 3, 1

    val rangesFour = 'a'..'z' // range contains the value from a to z

    var isPresent = 'c' in rangesFour

    var countDown = 10.downTo(1) // range contains the number of 10 ....1
    println(countDown)


    var moveUp = 1.rangeTo(10) // range contains the numbers of 1....10


}