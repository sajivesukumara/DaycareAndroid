package com.daycare.daycare1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import com.daycare.daycare1.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    internal lateinit var checkInternetConnection: CheckInternetConnection
    override fun onDateSet(p0: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        date.set(year, monthOfYear, dayOfMonth);
        (viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(date.time))
    }

    lateinit var date: Calendar;

    //lateinit var viewContainer;
    private lateinit var datePickerDialog: DatePickerDialog

    private lateinit var viewContainer: View;

    fun onCreateView_1(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewContainer = inflater?.inflate(R.layout.fragment_home, container, false);
        checkInternetConnection = CheckInternetConnection(activity)
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
        activity!!.runOnUiThread(Runnable {
            if (CheckInternetConnection.checkInternet(activity)) {
                callApi()
            } else {
                Toast.makeText(activity, "Please check your internet connection", Toast.LENGTH_LONG).show()
            }
        })

        return viewContainer
    }

    private fun getDateTime(data: Date): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd")
        return dateFormat.format(data)
    }

    fun callApi() {

        Util.showProgressBar(activity)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.login()
        Log.e("SAJIVE", "Login complete")
        call.enqueue(object : Callback<HomeResponse> {

                override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>?) {
                    Util.dismissProgressBar(activity)
                    if (response != null && response.body() != null) {
                        Log.e("SAJIVE", "Response "+response.body())
                        val loginRequest1 = response.body()
                        if (loginRequest1 != null) {
                            Log.e("SAJIVE", response.toString())
                            updateUI(loginRequest1);
                        } else {
                            //Toast.makeText(activity, "" + loginRequest1!!.message, Toast.LENGTH_SHORT).show()
                            Log.e("SAJIVE", "Failed request" + response.toString())
                        }
                    }
                    Log.e("SAJIVE", "Dont know what happened")
                }

                 fun onFailure1(call: Call<HomeResponse>, t: Throwable) {
                    // Log error here since request failed
                    Log.e("", t.toString())
                }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                // Toast for the moment
                // Appropriate error handling code should be present here
                Log.e("SAJIVE", t.toString())
                Toast.makeText(activity, "Failed !" + t.toString(), Toast.LENGTH_LONG).show()
            }

        })

    }

    private fun updateUI(loginRequest1: HomeResponse?) {
        (viewContainer.findViewById(R.id.activity_text) as TextView).setText(loginRequest1!!.activity.get(0).description + "")
        (viewContainer.findViewById(R.id.txtBreakfastFood) as TextView).setText(loginRequest1!!.activity.get(0).food.breakfast.toString() + "")
        (viewContainer.findViewById(R.id.txtLunchFood) as TextView).setText(loginRequest1!!.activity.get(0).food.lunch.toString() + "")
        (viewContainer.findViewById(R.id.txtSnacksFood) as TextView).setText(loginRequest1!!.activity.get(0).food.snacks.toString() + "")

        val breakfast: String = loginRequest1!!.activity.get(0).food.breakfast.amt + " " + loginRequest1!!.activity.get(0).food.breakfast.desc
        (viewContainer.findViewById(R.id.txtBreakfastFood) as TextView).setText(breakfast)

        val lunch: String = loginRequest1 !!. activity.get(0).food.lunch.amt + " " + loginRequest1!!.activity.get(0).food.lunch.desc
        (viewContainer.findViewById(R.id.txtLunch) as TextView).setText(lunch)

        val snacks: String = loginRequest1 !!. activity.get(0).food.snacks.amt + " " + loginRequest1!!.activity.get(0).food.lunch.desc
        (viewContainer.findViewById(R.id.txtBreakfastFood) as TextView).setText(lunch)
        //(viewContainer.findViewById(R.id.txtCalender) as TextView).setText(getDateTime(Date(loginRequest1!!.activity.get(0).date)))
    }


}