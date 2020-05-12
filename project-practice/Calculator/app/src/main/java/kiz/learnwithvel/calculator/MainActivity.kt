package kiz.learnwithvel.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operand1: Double? = null
    var pendingOperator = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNumbers()
        initOperation()
    }

    private fun initNumbers() {

        val listener = View.OnClickListener { v ->
            val button = v as Button

            if (button != btn_neg) {
                edt_new_number.append(button.text)
            } else {
                if (edt_new_number.text.isEmpty()) {
                    edt_new_number.append("-")
                } else {
                    var value = edt_new_number.text.toString().toDouble()
                    value *= -1
                    edt_new_number.setText(value.toString())
                }
            }

        }

        btn_0.setOnClickListener(listener)
        btn_1.setOnClickListener(listener)
        btn_2.setOnClickListener(listener)
        btn_3.setOnClickListener(listener)
        btn_4.setOnClickListener(listener)
        btn_5.setOnClickListener(listener)
        btn_6.setOnClickListener(listener)
        btn_7.setOnClickListener(listener)
        btn_8.setOnClickListener(listener)
        btn_9.setOnClickListener(listener)
        btn_dot.setOnClickListener(listener)
        btn_neg.setOnClickListener(listener)

    }

    private fun initOperation() {

        val listener = View.OnClickListener { v ->
            val operation = (v as Button).text.toString()

            try {
                val value = edt_new_number.text.toString().toDouble()
                performOperation(value)
            } catch (e: NumberFormatException) {
                edt_new_number.setText("")
            }


            pendingOperator = operation
            tv_operation.text = pendingOperator
            if (pendingOperator == "=") operand1 = null

        }

        btn_divide.setOnClickListener(listener)
        btn_multiply.setOnClickListener(listener)
        btn_minus.setOnClickListener(listener)
        btn_plus.setOnClickListener(listener)
        btn_equal.setOnClickListener(listener)
    }

    private fun performOperation(value: Double) {

        if (operand1 == null)
            operand1 = value
        else {

            when (pendingOperator) {
                "=" -> operand1 = value
                "/" -> operand1 = if (value == 0.0) Double.NaN
                else operand1!! / value
                "-" -> operand1 = operand1!! - value
                "+" -> operand1 = operand1!! + value
            }
        }

        edt_result.setText(operand1.toString())
        edt_new_number.setText("")
    }

}
