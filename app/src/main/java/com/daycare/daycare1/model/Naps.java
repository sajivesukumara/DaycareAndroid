
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Naps {

    @SerializedName("start")
    @Expose
    public String start;
    @SerializedName("end")
    @Expose
    public String end;

}
