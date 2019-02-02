
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hygiene {

    @SerializedName("diaper")
    @Expose
    public String diaper;
    @SerializedName("potty")
    @Expose
    public String potty;

}
