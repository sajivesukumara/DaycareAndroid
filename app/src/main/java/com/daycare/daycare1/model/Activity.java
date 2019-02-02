
package com.daycare.daycare1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("intime")
    @Expose
    public String intime;

    @SerializedName("outtime")
    @Expose
    public String outtime;

    @SerializedName("naps")
    @Expose
    public Naps naps;
    @SerializedName("food")
    @Expose
    public Food food;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("hygiene")
    @Expose
    public Hygiene hygiene;
    @SerializedName("mood")
    @Expose
    public String mood;
    @SerializedName("health")
    @Expose
    public String health;

}
