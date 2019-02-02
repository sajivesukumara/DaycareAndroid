
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("from")
    @Expose
    public String from;
    @SerializedName("msg_type")
    @Expose
    public String msgType;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("date")
    @Expose
    public String date;

}
