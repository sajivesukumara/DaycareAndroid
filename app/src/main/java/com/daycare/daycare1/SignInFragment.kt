package com.daycare.daycare1

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Intent
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.app.Activity
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.widget.Toast
import com.daycare.daycare1.R
import org.json.JSONException
import java.util.*

class SignInFragment : Fragment {

    lateinit var editTextEmail: TextInputEditText;
    lateinit var editTextPassword: TextInputEditText;
    lateinit var inputLayoutEmail: TextInputLayout;
    lateinit var inputLayoutPassword: TextInputLayout;


    constructor() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.signin_fragment, container, false)
        (view.findViewById(R.id.btnNext) as Button).setOnClickListener(View.OnClickListener {
home()

        })
        (view.findViewById(R.id.btnfacebook) as Button).setOnClickListener(View.OnClickListener {

home()
        })

        (view.findViewById(R.id.btnGoogle) as Button).setOnClickListener(View.OnClickListener {

home()
        })


        editTextEmail = (view.findViewById(R.id.txtInputEditTextPhoneNumber) as TextInputEditText)
        editTextPassword = (view.findViewById(R.id.txtInputEditTextPassword) as TextInputEditText)
        inputLayoutEmail = (view.findViewById(R.id.txtInputLayoutPhoneNumber) as TextInputLayout)
        inputLayoutPassword = (view.findViewById(R.id.txtInputLayoutPassword) as TextInputLayout)



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }

    public fun home(){
        val intent = Intent(activity, HomeActivity::class.java)
        activity!!.startActivity(intent)
    }


}