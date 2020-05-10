package kiz.learnwithvel.counter

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "text_content"

class MainActivity : AppCompatActivity() {

    //widgets
    private var tvOutput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
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
                Log.d(TAG, "onCreate() clicked!")
                tvOutput?.append(userInput.text)
                tvOutput?.append("\n")
                userInput.text.clear()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState()")
        tvOutput?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState()")
        outState.putString(TEXT_CONTENTS, tvOutput?.text.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

}
