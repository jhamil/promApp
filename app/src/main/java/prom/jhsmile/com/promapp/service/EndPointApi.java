package prom.jhsmile.com.promapp.service;

/**
 * Created by jhdev on 11-11-17.
 */

import java.util.ArrayList;

import prom.jhsmile.com.promapp.model.ProductOfert;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointApi {

    @GET("/promotion")
    Call<ArrayList<ProductOfert>> getList();
}
