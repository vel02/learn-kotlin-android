package kiz.learnwithvel.counter

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //widgets
    private var tvOutput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tv_output)
        val userInput: EditText = findViewById(R.id.edt_input)
        val btnSend: Button = findViewById(R.id.btn_send)

        //============== properties of textView =============//
        userInput.text.clear()
        tvOutput?.text = ""//clear field
        tvOutput?.movementMethod = ScrollingMovementMethod()

        //============== display message in tvOutput =============//
        btnSend.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                tvOutput?.append(userInput.text)
                tvOutput?.append("\n")
                userInput.text.clear()
            }
        })
    }
}
