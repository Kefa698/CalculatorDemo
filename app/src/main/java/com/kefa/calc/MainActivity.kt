package com.kefa.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {
        if (isNewOp) {
            edtShowNumber.setText("")
        }
        var isNewOp = false
        val buSelect = view as Button
        var buClickValue: String = edtShowNumber.text.toString()
        when (buSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                //TODO :prevent adding more than 1 Dot
                buClickValue += "."
            }
            buPlusMinus.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        edtShowNumber.setText(buClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun buOpEvent(view: View) {
        val buSelect = view as Button
        var buClickValue: String = edtShowNumber.text.toString()
        when (buSelect.id) {
            buMultiply.id -> {
                op = "*"

            }
            buAdd.id -> {
                op = "+"
            }
            buDivision.id -> {
                op = "/"
            }
            buSabtract.id -> {

                op = "-"
            }
        }
        oldNumber = edtShowNumber.text.toString()
        isNewOp = true
    }

    fun buEqualEvent(view: View) {
        val newNumber = edtShowNumber.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        edtShowNumber.setText(finalNumber.toString())
        isNewOp = true

    }

    fun buPercent(view: View) {
        val number: Double = edtShowNumber.text.toString().toDouble() / 100
        edtShowNumber.setText(number.toString())
        isNewOp = true

    }

    fun buClean(view: View) {
        edtShowNumber.setText("0")
        isNewOp = true

    }
}
