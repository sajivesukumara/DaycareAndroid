
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meals {

    @SerializedName("amt")
    @Expose
    public String amt;
    @SerializedName("desc")
    @Expose
    public String desc;

}
