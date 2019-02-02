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


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class EventFragment : Fragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(p0: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        date.set(year, monthOfYear, dayOfMonth);
        (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
    }

    lateinit var date: Calendar;

    //lateinit var viewContainer;
    private lateinit var datePickerDialog: DatePickerDialog

    private lateinit var viewContainer: View ;

    /* override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                       savedInstanceState: Bundle?): View? {
                 return inflater?.inflate(R.layout.fragment_home, container, false)
             }
         */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewContainer = inflater?.inflate(R.layout.fragment_event, container, false);
        date = Calendar.getInstance();
        datePickerDialog = DatePickerDialog(
                context, this, 1950, 1, 1)
        (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
        (viewContainer.findViewById(R.id.txtCalender) as TextView).setOnClickListener(
                View.OnClickListener {
                    datePickerDialog.show()
                }
        )

        (viewContainer.findViewById(R.id.imgvwLeft) as ImageView).setOnClickListener(
                View.OnClickListener {
                    date.add(Calendar.DATE, -1);
                    (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
                }
        )

        (viewContainer.findViewById(R.id.imgvwRight) as ImageView).setOnClickListener(
                View.OnClickListener {
                    date.add(Calendar.DATE, 1);
                    (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
                }
        )
        return viewContainer
    }

    private fun getDateTime(data : Date): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd")
        return dateFormat.format(data)
    }


}
