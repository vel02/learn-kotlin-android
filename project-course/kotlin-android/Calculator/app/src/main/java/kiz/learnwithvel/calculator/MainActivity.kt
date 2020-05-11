package kiz.learnwithvel.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

//constants
private const val STATE_PENDING_OPERATION: String = "STATE_PENDING_OPERATION"
private const val STATE_OPERAND_VALUE: String = "STATE_OPERAND_VALUE"
private const val STATE_OPERAND_STORED: String = "STATE_OPERAND_STORED"

class MainActivity : AppCompatActivity() {


    //Approach #1: late initialization
    //widgets
//    private lateinit var mResult: EditText
//    private lateinit var mNewNumber: EditText

    //Approach #2: lazy initialization (thread safe as default) LazyThreadSafetyMode.NONE to of thread safe
//    private val mDisplayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.tv_operation) }

    //variables to hold the operands and type of calculation
    private var mOperand1: Double? = null
    private var mPendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mResult = findViewById(R.id.edt_result)
//        mNewNumber = findViewById(R.id.edt_newNumber)

        // Data input buttons
//        val btn0: Button = findViewById(R.id.btn_0)
//        val btn1: Button = findViewById(R.id.btn_1)
//        val btn2: Button = findViewById(R.id.btn_2)
//        val btn3: Button = findViewById(R.id.btn_3)
//        val btn4: Button = findViewById(R.id.btn_4)
//        val btn5: Button = findViewById(R.id.btn_5)
//        val btn6: Button = findViewById(R.id.btn_6)
//        val btn7: Button = findViewById(R.id.btn_7)
//        val btn8: Button = findViewById(R.id.btn_8)
//        val btn9: Button = findViewById(R.id.btn_9)
//        val btnDot: Button = findViewById(R.id.btn_dot)

        // Operation buttons
//        val btnEquals: Button = findViewById(R.id.btn_equal)
//        val btnDivide: Button = findViewById(R.id.btn_divide)
//        val btnMultiply: Button = findViewById(R.id.btn_multiply)
//        val btnMinus: Button = findViewById(R.id.btn_minus)
//        val btnPlus: Button = findViewById(R.id.btn_plus)

        // ============= Data Input Listener ============= //

        val mListener = View.OnClickListener { v ->
            val b = v as Button// up-casting
            edt_newNumber.append(b.text)
        }

        btn_0.setOnClickListener(mListener)
        btn_1.setOnClickListener(mListener)
        btn_2.setOnClickListener(mListener)
        btn_3.setOnClickListener(mListener)
        btn_4.setOnClickListener(mListener)
        btn_5.setOnClickListener(mListener)
        btn_6.setOnClickListener(mListener)
        btn_7.setOnClickListener(mListener)
        btn_8.setOnClickListener(mListener)
        btn_9.setOnClickListener(mListener)
        btn_dot.setOnClickListener(mListener)

        val mOpListener = View.OnClickListener { v ->
            val operation = (v as Button).text.toString()

            //dot crash fixed
            try {
                val value = edt_newNumber.text.toString().toDouble()
                performOperation(value, operation)
            } catch (e: NumberFormatException) {
                edt_newNumber.setText("")
            }

            mPendingOperation = operation
            tv_operation.text = mPendingOperation
        }

        btn_equal.setOnClickListener(mOpListener)
        btn_divide.setOnClickListener(mOpListener)
        btn_multiply.setOnClickListener(mOpListener)
        btn_minus.setOnClickListener(mOpListener)
        btn_plus.setOnClickListener(mOpListener)
    }

    private fun performOperation(value: Double, operation: String) {

        if (mOperand1 == null)
            mOperand1 = value
        else {
            if (mPendingOperation == "=")
                mPendingOperation = operation

            when (mPendingOperation) {
                "=" -> mOperand1 = value
                "/" -> mOperand1 = if (value == 0.0)
                    Double.NaN// handle attempt to divide by zero
                else mOperand1!! / value
                "*" -> mOperand1 = mOperand1!! * value
                "-" -> mOperand1 = mOperand1!! - value
                "+" -> mOperand1 = mOperand1!! + value
            }
        }

        edt_result.setText(mOperand1.toString())
        edt_newNumber.setText("")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mOperand1 != null) {
            outState.putDouble(STATE_OPERAND_VALUE, mOperand1!!)
            outState.putBoolean(STATE_OPERAND_STORED, true)
        }
        outState.putString(STATE_PENDING_OPERATION, mPendingOperation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION).toString()

        mOperand1 = if (savedInstanceState.getBoolean(STATE_OPERAND_STORED, false)) {
            savedInstanceState.getDouble(STATE_OPERAND_VALUE)
        } else null

        tv_operation.text = mPendingOperation
        edt_result.setText(mOperand1.toString())
    }

}
