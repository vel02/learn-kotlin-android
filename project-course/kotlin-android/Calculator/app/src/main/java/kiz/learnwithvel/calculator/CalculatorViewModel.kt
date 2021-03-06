package kiz.learnwithvel.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {


    //variables to hold the operands and type of calculation
    private var mOperand1: Double? = null
    private var mPendingOperation = "="

    private val result = MutableLiveData<Double>()
    val stringResult: LiveData<String>
        get() = Transformations.map(result) { it.toString() }

    private val newNumber = MutableLiveData<String>()
    val stringNewNumber: LiveData<String>
        get() = newNumber

    private val operation = MutableLiveData<String>()
    val stringOperation: LiveData<String>
        get() = operation

    fun digitPressed(caption: String) {
        if (newNumber.value != null) {
            newNumber.value = newNumber.value + caption
        } else {
            newNumber.value = caption
        }
    }

    fun operandPressed(op: String) {

        //dot crash fixed
        try {
            val value = newNumber.value?.toDouble()
            if (value != null) {
                performOperation(value, op)
            }
        } catch (e: NumberFormatException) {
            newNumber.value = ""
        }

        mPendingOperation = op
        operation.value = mPendingOperation
    }

    fun negPressed() {
        val value = newNumber.value
        if (value == null || value.isEmpty()) {
            newNumber.value = "-"
        } else {
            try {
                var doubleValue = value.toDouble()
                doubleValue *= -1
                newNumber.value = doubleValue.toString()
            } catch (e: java.lang.NumberFormatException) {
                newNumber.value = ""
            }
        }
    }

    private fun performOperation(value: Double, operation: String) {

        if (mOperand1 == null)
            mOperand1 = value
        else {
            if (mPendingOperation == "=") {
                mPendingOperation = operation
            }

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

        result.value = mOperand1
        newNumber.value = ""
    }

}