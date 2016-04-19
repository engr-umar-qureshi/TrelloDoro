package com.umarqasim.trellodoroapi.controller;

import com.umarqasim.trellodoroapi.events.EventModelUser;
import com.umarqasim.trellodoroapi.interfaces.InterfaceUser;
import com.umarqasim.trellodoroapi.model.ModelUser;
import com.umarqasim.trellodoroapi.parsers.ParserUser;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiConstants;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiWebConstants;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroErrorCodes;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class ControllerUser {

    Retrofit mRetrofitClient;
    InterfaceUser mUserInterface;
    ParserUser mParserUser;

    public ControllerUser(Retrofit mRetrofitClient) {
        this.mRetrofitClient = mRetrofitClient;
        mUserInterface = this.mRetrofitClient.create(InterfaceUser.class);
        mParserUser = new ParserUser();
    }

    public void getModelUser(final String userToken)
    {
        Call<ResponseBody> getUsername =  mUserInterface.getUsername(userToken, TrellodoroApiConstants.TRELLO_API_KEY, TrellodoroApiWebConstants.USER_FIELD_USERNAME);

        getUsername.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    try {
                        String responseString = response.body().string();
                        getMemberDetail(userToken,mParserUser.getUsername(responseString));

                    }
                    catch (IOException e)
                    {
                        onEventModelUserFailed(TrellodoroErrorCodes.ERROR_RESPONSE);
                    }
                    catch (JSONException e)
                    {
                        onEventModelUserFailed(TrellodoroErrorCodes.ERROR_PARSING);
                    }

                }
                else {
                    onEventModelUserFailed(TrellodoroErrorCodes.ERROR_CALL_FAILED);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onEventModelUserFailed(TrellodoroErrorCodes.ERROR_CONNECTION_FAILED);
            }
        });

    }

    private void getMemberDetail(String userToken,String userName)
    {
        Call<ResponseBody> getMemberDetailCall =  mUserInterface.getMemberDetail(userName, userToken, TrellodoroApiConstants.TRELLO_API_KEY, TrellodoroApiWebConstants.USER_FIELD_DISPLAYNAME + "," + TrellodoroApiWebConstants.USER_FIELD_USERNAME, TrellodoroApiWebConstants.BOARD_TYPE_ALL);

        getMemberDetailCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responseString = response.body().string();
                        onEventModelUserCompleted(mParserUser.getModelUser(responseString));

                    } catch (IOException e) {
                        onEventModelUserFailed(TrellodoroErrorCodes.ERROR_RESPONSE);
                    }

                } else {
                    onEventModelUserFailed(TrellodoroErrorCodes.ERROR_CALL_FAILED);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onEventModelUserFailed(TrellodoroErrorCodes.ERROR_CONNECTION_FAILED);
            }
        });

    }


    private void onEventModelUserFailed(TrellodoroErrorCodes errorCode){
        EventBus.getDefault().post(new EventModelUser(null, false, errorCode));
    }

    private void onEventModelUserCompleted(ModelUser modelUser){
        EventBus.getDefault().post(new EventModelUser(modelUser,true,null));
    }

}
