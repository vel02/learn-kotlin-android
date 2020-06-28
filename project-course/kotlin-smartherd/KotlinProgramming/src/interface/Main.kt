package `interface`

fun main(args: Array<String>) {

    val btn = Button()
    btn.onTouch()
    btn.onClick()


}

interface MyInterfaceListener {       // You cannot create instance of interface


    fun onTouch()           // Methods in interface are abstract by default

    fun onClick() {
        println("MyInterfaceListener: onClick")
    }          // Normal Methods ar public and open by default NOT FINAL


}

interface MySecondInterface {       // You cannot create instance of interface


    fun onTouch() {
        println("MySecondInterface: onTouch")
    }

    fun onClick() {
        println("MySecondInterface: onClick")
    }          // Normal Methods ar public and open by default NOT FINAL


}

class Button : MyInterfaceListener, MySecondInterface {

    override fun onTouch() {
        super.onTouch()
    }

    override fun onClick() {
        super<MyInterfaceListener>.onClick()
        super<MySecondInterface>.onClick()
    }


}