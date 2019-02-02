
package com.daycare.daycare1.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationResponse {

    @SerializedName("notification")
    @Expose
    public List<Notification> notification = new ArrayList<>();

}
