package com.daycare.daycare1


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.daycare.daycare1.model.NotificationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
class NotificationFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    override fun onDateSet(p0: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        date.set(year, monthOfYear, dayOfMonth);
        (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
    }

    lateinit var date: Calendar;

    private lateinit var recyclerview: RecyclerView

    //lateinit var viewContainer;
    private lateinit var datePickerDialog: DatePickerDialog

    private lateinit var viewContainer: View;

    /* override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                       savedInstanceState: Bundle?): View? {
                 return inflater?.inflate(R.layout.fragment_home, container, false)
             }
         */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewContainer = inflater?.inflate(R.layout.fragment_notification, container, false);
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
        recyclerview = (viewContainer.findViewById(R.id.recyclerView) as RecyclerView)
        setAdapter(recyclerview);
        callApi()
        return viewContainer
    }

    private fun getDateTime(data: Date): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd")
        return dateFormat.format(data)
    }

    private lateinit var obj_adapter: NotificationAdapter;

    private fun setAdapter(recyclerview: RecyclerView) {
        obj_adapter = NotificationAdapter()
        recyclerview.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        recyclerview.adapter = obj_adapter
    }

    fun callApi() {

        Util.showProgressBar(activity)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.notification()
        call.enqueue(object : Callback<NotificationResponse> {
            override fun onResponse(call: Call<NotificationResponse>, response: Response<NotificationResponse>?) {
                Util.dismissProgressBar(activity)
                if (response != null && response.body() != null) {
                    val loginRequest1 = response.body()
                    if (loginRequest1 != null) {
                        obj_adapter.updateList(loginRequest1.notification);
                    } else {
                        //Toast.makeText(activity, "" + loginRequest1!!.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<NotificationResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e("", t.toString())
            }
        })
    }

}
