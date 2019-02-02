package com.daycare.daycare1


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import com.daycare.daycare1.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment(){

    private lateinit var viewContainer: View ;

    /* override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                       savedInstanceState: Bundle?): View? {
                 return inflater?.inflate(R.layout.fragment_home, container, false)
             }
         */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}
