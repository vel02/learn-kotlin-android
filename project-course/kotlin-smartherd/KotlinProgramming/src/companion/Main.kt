package companion

fun main(args: Array<String>) {

    MyClass.count
    MyClass.typeOfCustomers()

}

class MyClass {
    companion object {

        val count: Int = -1

        fun typeOfCustomers() = "Indian"
    }
}