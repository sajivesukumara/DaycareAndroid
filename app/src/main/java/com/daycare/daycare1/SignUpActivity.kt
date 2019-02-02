package com.daycare.daycare1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.arch.lifecycle.Observer
import android.content.DialogInterface
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.daycare.daycare1.R
import com.daycare.daycare1.R.id.relativeDate
import com.daycare.daycare1.R.id.textInputEditextPassword
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONException
import java.util.*


class SignUpActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {


    lateinit var selectedDate: String;
    lateinit var selectedDepartment: String;
    lateinit var datePickerDialog: DatePickerDialog;


    override fun onDateSet(p0: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int) {
        selectedDate = selectedYear.toString() + "-" + (selectedMonth + 1) + "-" + selectedDay.toString();

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        (findViewById(R.id.btnNext) as Button).setOnClickListener(View.OnClickListener {
            home()
        })
        (findViewById(R.id.btnfacebook) as Button).setOnClickListener(View.OnClickListener {
            home()
        })

        (findViewById(R.id.btnGoogle) as Button).setOnClickListener(View.OnClickListener {

            home()
        })


        selectedDate = ""
        selectedDepartment = ""
        datePickerDialog = DatePickerDialog(
                this@SignUpActivity, this@SignUpActivity, 1900, 1, 1)


        (findViewById(R.id.imgBack) as ImageView).setOnClickListener(View.OnClickListener {
            finish()
        })



        relativeDate.setOnClickListener(View.OnClickListener {
            datePickerDialog.show()
        })

        relativeDepartment.setOnClickListener(View.OnClickListener {
            showDepartmentDialog()
        })


    }

    private fun showDepartmentDialog() {
        val builderSingle = AlertDialog.Builder(this@SignUpActivity)
        builderSingle.setTitle("Select Any Department")

        val arrayAdapter = ArrayAdapter<String>(this@SignUpActivity, android.R.layout.select_dialog_singlechoice)
        arrayAdapter.add("Hardik")
        arrayAdapter.add("Archit")
        arrayAdapter.add("Jignesh")
        arrayAdapter.add("Umang")
        arrayAdapter.add("Gatti")

        builderSingle.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter, DialogInterface.OnClickListener { dialog, which ->
            val strName = arrayAdapter.getItem(which)
            selectedDepartment = strName
            textViewDepartment.setText(strName)
        })
        builderSingle.show()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            hideKeyBoard()
        }
        return super.dispatchTouchEvent(event)
    }

    fun hideKeyBoard() {

        if (currentFocus != null && currentFocus!!.windowToken != null) {
            currentFocus!!.clearFocus()
            val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(this.window.decorView.rootView.windowToken, 0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }


    public fun home() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}
