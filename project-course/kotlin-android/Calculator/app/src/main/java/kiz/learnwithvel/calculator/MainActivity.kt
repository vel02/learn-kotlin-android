package kiz.learnwithvel.calculator

//Using synthetic for binding views
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: BigDecimalViewModel by viewModels()

        viewModel.stringResult.observe(this, Observer { stringResult ->
            edt_result.setText(stringResult)
        })

        viewModel.stringNewNumber.observe(this, Observer { stringNumber ->
            edt_newNumber.setText(stringNumber)
        })

        viewModel.stringOperation.observe(this, Observer { stringOperation ->
            tv_operation.text = stringOperation
        })

        // ============= Data Input Listener ============= //

        val mListener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
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
            viewModel.operandPressed((v as Button).text.toString())
        }

        btn_equal.setOnClickListener(mOpListener)
        btn_divide.setOnClickListener(mOpListener)
        btn_multiply.setOnClickListener(mOpListener)
        btn_minus.setOnClickListener(mOpListener)
        btn_plus.setOnClickListener(mOpListener)

        btn_neg.setOnClickListener {
            viewModel.negPressed()
        }
    }
}
