
package com.daycare.daycare1.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResponse {

    @SerializedName("activity")
    @Expose
    public List<Activity> activity = new ArrayList<>();

}
