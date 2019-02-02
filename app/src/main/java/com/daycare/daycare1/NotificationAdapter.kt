package com.daycare.daycare1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daycare.daycare1.R
import com.daycare.daycare1.model.Notification
import kotlinx.android.synthetic.main.notification_list_item.view.*
import java.util.ArrayList


class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    var notification: List<Notification> = ArrayList()
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.notification_list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fromMessage.setText(notification.get(position).from)
        holder.description.setText(notification.get(position).msg)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return notification.size
    }

    public fun updateList( notify: List<Notification>){
        notification= notify;
        notifyDataSetChanged()
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val fromMessage = itemView.textView3
        val description = itemView.textView5

    }

}