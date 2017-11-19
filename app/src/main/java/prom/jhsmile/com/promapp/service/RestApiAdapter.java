package prom.jhsmile.com.promapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jhdev on 17-11-17.
 */

public class RestApiAdapter {

    public EndPointApi connexionToApi() {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(ConstantsRestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndPointApi service = retrofit.create(EndPointApi.class);
        return service;
    }

}
