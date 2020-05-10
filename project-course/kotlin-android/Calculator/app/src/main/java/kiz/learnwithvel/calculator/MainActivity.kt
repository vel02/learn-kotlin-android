package kiz.learnwithvel.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //Approach #1: late initialization
    //widgets
    private lateinit var mResult: EditText
    private lateinit var mNewNumber: EditText

    //Approach #2: lazy initialization (thread safe as default) LazyThreadSafetyMode.NONE to of thread safe
    private val mDisplayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.tv_operation) }

    //variables to hold the operands and type of calculation
    private var mOperand1: Double? = null
    private var mOperand2: Double = 0.0
    private var mPendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mResult = findViewById(R.id.edt_result)
        mNewNumber = findViewById(R.id.edt_newNumber)

        // Data input buttons
        val btn0: Button = findViewById(R.id.btn_0)
        val btn1: Button = findViewById(R.id.btn_1)
        val btn2: Button = findViewById(R.id.btn_2)
        val btn3: Button = findViewById(R.id.btn_3)
        val btn4: Button = findViewById(R.id.btn_4)
        val btn5: Button = findViewById(R.id.btn_5)
        val btn6: Button = findViewById(R.id.btn_6)
        val btn7: Button = findViewById(R.id.btn_7)
        val btn8: Button = findViewById(R.id.btn_8)
        val btn9: Button = findViewById(R.id.btn_9)
        val btnDot: Button = findViewById(R.id.btn_dot)

        // Operation buttons
        val btnEquals: Button = findViewById(R.id.btn_equal)
        val btnDivide: Button = findViewById(R.id.btn_divide)
        val btnMultiply: Button = findViewById(R.id.btn_multiply)
        val btnMinus: Button = findViewById(R.id.btn_minus)
        val btnPlus: Button = findViewById(R.id.btn_plus)

        // ============= Data Input Listener ============= //

        val mListener = View.OnClickListener { v ->
            val b = v as Button// up-casting
            mNewNumber.append(b.text)
        }

        btn0.setOnClickListener(mListener)
        btn1.setOnClickListener(mListener)
        btn2.setOnClickListener(mListener)
        btn3.setOnClickListener(mListener)
        btn4.setOnClickListener(mListener)
        btn5.setOnClickListener(mListener)
        btn6.setOnClickListener(mListener)
        btn7.setOnClickListener(mListener)
        btn8.setOnClickListener(mListener)
        btn9.setOnClickListener(mListener)
        btnDot.setOnClickListener(mListener)

        val mOpListener = View.OnClickListener { v ->
            val operation = (v as Button).text.toString()

            //dot crash fixed
            try {
                val value = mNewNumber.text.toString().toDouble()
                performOperation(value, operation)
            } catch (e: NumberFormatException) {
                mNewNumber.setText("")
            }

            mPendingOperation = operation
            mDisplayOperation.text = mPendingOperation
        }

        btnEquals.setOnClickListener(mOpListener)
        btnDivide.setOnClickListener(mOpListener)
        btnMultiply.setOnClickListener(mOpListener)
        btnMinus.setOnClickListener(mOpListener)
        btnPlus.setOnClickListener(mOpListener)
    }

    private fun performOperation(value: Double, operation: String) {
        if (mOperand1 == null)
            mOperand1 = value
        else {
            mOperand2 = value
            if (mPendingOperation == "=")
                mPendingOperation = operation

            when (mPendingOperation) {
                "=" -> mOperand1 = mOperand2
                "/" -> if (mOperand2 == 0.0)
                    mOperand1 = Double.NaN// handle attempt to divide by zero
                else mOperand1 = mOperand1!! / mOperand2
                "*" -> mOperand1 = mOperand1!! * mOperand2
                "-" -> mOperand1 = mOperand1!! - mOperand2
                "+" -> mOperand1 = mOperand1!! + mOperand2
            }
        }

        mResult.setText(mOperand1.toString())
        mNewNumber.setText("")

    }

}
