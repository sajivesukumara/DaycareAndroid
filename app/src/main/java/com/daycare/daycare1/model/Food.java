
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("breakfast")
    @Expose
    public Meals breakfast;
    @SerializedName("lunch")
    @Expose
    public Meals lunch;
    @SerializedName("snacks")
    @Expose
    public Meals snacks;

}
