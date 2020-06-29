package singleton

fun main(args: Array<String>) {

    Customer.id = 20
    Customer.registerCustomer()

    println(Customer.id)
    Customer.id = 109
    println(Customer.id)

    Customer.myMethod("Hello")
}

open class SupperClass {
    open fun myMethod(str: String) {
        println("Supper Class")
    }

}

object Customer : SupperClass() {
    var id: Int = -1

    fun registerCustomer(): String {
        return "Indian"
    }

    override fun myMethod(str: String) {
        super.myMethod(str)
        println("Customer")
    }

    init {
        println("Init")
    }
}