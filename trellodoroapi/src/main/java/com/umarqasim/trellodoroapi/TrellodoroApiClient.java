package com.umarqasim.trellodoroapi;

import com.umarqasim.trellodoroapi.controller.ControllerUser;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiConstants;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiWebConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class TrellodoroApiClient {

    private static Retrofit mRetrofitClient;
    private static TrellodoroApiClient trellodoroApiClient;

    private ControllerUser controllerUser;

    public TrellodoroApiClient() {
        mRetrofitClient = new Retrofit.Builder()
                .baseUrl(TrellodoroApiWebConstants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    public static TrellodoroApiClient getClient()
    {
        if(trellodoroApiClient==null)
        {
            trellodoroApiClient = new TrellodoroApiClient();
        }

        return trellodoroApiClient;
    }


    public ControllerUser getControllerUser()
    {
        return new ControllerUser(mRetrofitClient);
    }


    // OKhttp connection
    public static OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS).build();

        return client;
    }

}
