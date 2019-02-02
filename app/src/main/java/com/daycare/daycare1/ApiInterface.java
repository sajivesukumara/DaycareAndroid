package com.daycare.daycare1;

import com.daycare.daycare1.model.HomeResponse;
import com.daycare.daycare1.model.NotificationResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("activity")
    Call<HomeResponse> login();

    @GET("notify")
    Call<NotificationResponse> notification();

}
